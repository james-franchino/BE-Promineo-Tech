package dao;

import entity.*;
import exception.DbException;
import util.DaoBase;

import java.sql.*;
import java.time.LocalTime;
import java.util.*;

public class RecipeDao extends DaoBase {
  private static final String CATEGORY_TABLE = "category";
  private static final String INGREDIENT_TABLE = "ingredient";
  private static final String RECIPE_TABLE = "recipe";
  private static final String RECIPE_CATEGORY = "recipe_category";
  private static final String STEP_TABLE = "step";
  private static final String UNIT_TABLE = "unit";

  public Optional<Recipe> fetchRecipeById(Integer recipeId) throws SQLException {
    String sql = "SELECT * FROM " + RECIPE_TABLE + " WHERE recipe_id = ?";

    try(Connection conn = DbConnection.getConnection()) {
      startTransaction(conn);

      try {
        Recipe recipe = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          setParameter(stmt, 1, recipeId, Integer.class);

          try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
              recipe = extract(rs, Recipe.class);
            }
          }
        }

        if (Objects.nonNull(recipe)) {
          recipe.getIngredients().addAll(fetchRecipeIngredients(conn, recipeId));
          recipe.getSteps().addAll(fetchRecipeSteps(conn, recipeId));
          recipe.getCategories().addAll(fetchRecipeCategories(conn, recipeId));
        }
        return Optional.ofNullable(recipe);
      }
      catch (Exception e) {
        rollbackTransaction(conn);
        throw new DbException(e);
      }
    }
    catch (SQLException e) {
      throw new DbException(e);
    }

  }

  private List<Category> fetchRecipeCategories(Connection conn, Integer recipeId) throws SQLException {
    // formatter:off
    String sql = ""
            + "SELECT c.*"
            + " FROM " + RECIPE_CATEGORY + " rc "
            + " JOIN " + CATEGORY_TABLE + " c USING (category_id) "
            + " WHERE c.recipe_id = ?"
            + " ORDER BY c.category_name";
    // formatter:on

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
      setParameter(stmt, 1, recipeId, Integer.class);

      try (ResultSet rs = stmt.executeQuery()) {
        List<Category> categories = new LinkedList<Category>();

        while (rs.next()) {
          categories.add(extract(rs, Category.class));
        }
        return categories;
      }

    }

  }

  private List<Step> fetchRecipeSteps(Connection conn, Integer recipeId) throws SQLException {
    String sql = "SELECT * FROM " + STEP_TABLE +  " s WHERE s.recipe_id = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
      setParameter(stmt, 1, recipeId, Integer.class);

      try (ResultSet rs = stmt.executeQuery()) {
        List<Step> steps = new LinkedList<Step>();

        while (rs.next()) {
          steps.add(extract(rs, Step.class));
        }

        return steps;
      }
    }
  }

  private List<Ingredient> fetchRecipeIngredients(Connection conn, Integer recipeId) throws SQLException {
    // @formatter:off
    String sql = ""
            + "SELECT i.*, u.unit_name_singular, u.unit_name_plural "
            + "FROM " + RECIPE_TABLE + " i "
            + "LEFT JOIN " + UNIT_TABLE + " u USING (unit_id) "
            + "WHERE i.recipe_id = ?"
            + "ORDER BY i.ingredient_order";
    // @formatter:on
    try(PreparedStatement stmt = conn.prepareStatement(sql)) {
      setParameter(stmt, 1, recipeId, Integer.class);

      try (ResultSet rs = stmt.executeQuery()) {
        List<Ingredient> ingredients = new LinkedList<Ingredient>();

        while (rs.next()) {
          Ingredient ingredient = extract(rs, Ingredient.class);
          Unit unit = extract(rs, Unit.class);

          ingredient.setUnit(unit);
          ingredients.add(ingredient);
        }

        return ingredients;
      }

    }
  }

  public void executeBatch(List<String> sqlBatch) {

  }


    public Recipe insertRecipe(Recipe recipe) {
    // @formatter:off
      String sql = ""
              + "INSERT INTO " + RECIPE_TABLE + " "
              + " (recipe_name, notes, num_servings, prep_time, cook_time) "
              + "VALUES "
              + "(?, ?, ?, ?, ?)";
      // @formatter:on

      try (Connection conn = DbConnection.getConnection()) {
        startTransaction(conn);

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
          setParameter(stmt, 1, recipe.getRecipeName(), String.class);
          setParameter(stmt, 2, recipe.getNotes(), String.class);
          setParameter(stmt, 3, recipe.getNumServings(), Integer.class);
          setParameter(stmt, 4, recipe.getPrepTime(), LocalTime.class);
          setParameter(stmt, 5, recipe.getCookTime(), LocalTime.class);

          /*
           * Insert the row. Statement.executeUpdate() performs inserts,
           * deletions, and modifications. It does all operations that do not
           * return result sets.
           */
          stmt.executeUpdate();

          /*
           * Call a method in the base class to get the last insert ID (primary
           * key value) in the given table.
           */
          Integer recipeId = getLastInsertId(conn, RECIPE_TABLE);

          commitTransaction(conn);

          /*
           * Set the recipe ID primary key to the value obtained by
           * getLastInsertId(). This does not fill in the createdAt field. To get
           * that value we would need to do a fetch on the recipe row.
           */
          recipe.setRecipeId(recipeId);
          return recipe;
        } catch (Exception e) {
          rollbackTransaction(conn);
          throw new DbException(e);
        }
      } catch (SQLException e) {
        throw new DbException(e);
      }
    }

  public List<Recipe> fetchAllRecipes() throws SQLException {
    String sql = "SELECT * FROM " + RECIPE_TABLE + " ORDER BY recipe_name";

    try(Connection conn = DbConnection.getConnection()) {
      startTransaction(conn);
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        try (ResultSet rs = stmt.executeQuery()) {
          List<Recipe> recipes = new LinkedList<>();

          while (rs.next()) {
            recipes.add(extract(rs, Recipe.class));
          }
          return recipes;
        }

      }
      catch (Exception e) {
        rollbackTransaction(conn);
        throw new DbException(e);

    }
    }
    catch (SQLException e) {
      throw new DbException(e);
    }
  }
}