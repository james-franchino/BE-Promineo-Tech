package service;

import dao.RecipeDao;
import entity.Recipe;
import exception.DbException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class RecipeService {
    private static final String SCHEMA_FILE = "recipe_schema.sql";
    private static final String DATA_FILE = "recipe_data.sql";

    private RecipeDao recipeDao = new RecipeDao();

    public void createAndPopulateTables() {
        loadFromFile(SCHEMA_FILE);
        loadFromFile(DATA_FILE);
    }

    private void loadFromFile(String fileName) {
        String content = readFileContent(fileName);
        List<String> sqlStatements = convertContentToSqlStatements(content);

        sqlStatements.forEach(line -> System.out.println(line));

        recipeDao.executeBatch(sqlStatements);
    }

    private List<String> convertContentToSqlStatements(String content) {
        content = removeComments(content);
        content = replaceWhitespaceSequencesWithSingleSpace(content);

        return extractLinesFromContent(content);
    }

    private List<String> extractLinesFromContent(String content) {
        List<String> lines = new LinkedList<>();
        while (!content.isEmpty()) {
            int semicolon = content.indexOf(';');

            if (semicolon == -1) {
                if (!content.isBlank()) {
                    lines.add(content);
                }
                content = "";
            } else {
                lines.add(content.substring(0, semicolon).trim());
                content = content.substring(semicolon + 1);
            }
        }

        return lines;
    }

    private String replaceWhitespaceSequencesWithSingleSpace(String content) {
        content = content.replaceAll("\\s+", " ");

        return content;
    }

    private String removeComments(String content) {
        content = content.replaceAll("#.*?#", "");
        content = content.replaceAll("\\*.*?\\*", "");
        return content;
    }

    private String readFileContent(String fileName) {
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
            return Files.readString(path);
        } catch (Exception e) {
            throw new DbException(e);
        }

    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeDao.insertRecipe(recipe);
    }
}


