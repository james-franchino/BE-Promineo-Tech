package dao;

import entity.Recipe;
import exception.DbException;
import util.DaoBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.List;

public class RecipeDao extends DaoBase {
  private static final String CATEGORY_TABLE = "category";
  private static final String INGREDIENT_TABLE = "ingredient";
  private static final String RECIPE_TABLE = "recipe";
  private static final String RECIPE_CATEGORY = "recipe_category";
  private static final String STEP_TABLE = "step";
  private static final String UNIT_TABLE = "unit";
  public void executeBatch(List<String> sqlBatch) {

  }

    public Recipe insertRecipe(Recipe recipe) {
    // @formatter:off
      String sql = ""
              + "INSERT INTO " + RECIPE_TABLE + " "
              + "(recipe_name, notes, num_servings, prep_time, cook_time) "
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

}

/*
public void executeBatch(List<String> sqlBatch) {
  try (Connection conn = DbConnection.getConnection()) {
    conn.setAutoCommit(false);  // Start transaction

    for (String sql : sqlBatch) {
      try (Statement stmt = conn.createStatement()) {
        System.out.println("Executing: " + sql);
        stmt.executeUpdate(sql);
        System.out.println("Executed successfully.");
      } catch (SQLException e) {
        System.out.println("Failed to execute: " + sql);
        System.out.println("Error: " + e.getMessage());
      }
    }

    conn.commit();  // Commit transaction
  } catch (SQLException e) {
    System.out.println("Transaction failed. Rolling back.");
    e.printStackTrace();
    throw new DbException("Error executing SQL batch", e);
  }
}}*/
