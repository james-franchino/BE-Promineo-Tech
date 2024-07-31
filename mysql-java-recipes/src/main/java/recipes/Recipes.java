package recipes;

import entity.Recipe;
import exception.DbException;
import service.RecipeService;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Recipes {
    private Scanner scanner = new Scanner(System.in);
    private RecipeService recipeService = new RecipeService();

    private List<String> operations = List.of(
            "1) Create and populate all tables",
            "2) Add a recipe"

    );

    public static void main(String[] args) {
        new Recipes().displayMenu();
    }

    private void displayMenu() {
        boolean done = false;

        while (!done) {
            try {
            int operation = getOperation();

                switch (operation) {
                    case -1:
                        done = exitMenu();
                        break;

                    case 1:
                        createTables();
                        break;

                    case 2:
                        addRecipe();
                        break;

                    default:
                        System.out.println("\n" + operation + " is not a valid operation. Try again.");
                }
            } catch (Exception e) {
                System.out.println("\n" + e.toString() + " Try again.");
            }
        }
    }

    private void addRecipe() {
        String name = getStringInput("Please enter the name of the recipe: ");
        String notes = getStringInput("Please enter the recipe notes: ");
        Integer numServings = getIntInput("Please enter the number of servings: ");
        Integer prepMin = getIntInput("Please enter the prep time in minutes: ");
        Integer cookMin = getIntInput("Please enter the cook time in minutes: ");
        LocalTime prepTime = minutesToLocalTime(prepMin);
        LocalTime cookTime = minutesToLocalTime(cookMin);

        Recipe recipe = new Recipe();

        recipe.setRecipeName(name);
        recipe.setNotes(notes);
        recipe.setNumServings(numServings);
        recipe.setPrepTime(prepTime);
        recipe.setCookTime(cookTime);

        Recipe dbRecipe = recipeService.addRecipe(recipe);
        System.out.println("You added this recipe:\n" + dbRecipe);
    }

    private LocalTime minutesToLocalTime(Integer numMinutes) {
        int min = Objects.isNull(numMinutes) ? 0 : numMinutes;
        int hours = min / 60;
        int minutes = min % 60;
        return LocalTime.of(hours, minutes);
    }

    private void createTables() {
        recipeService.createAndPopulateTables();
        System.out.println("Created and populated all tables");
    }

    private boolean exitMenu() {
        System.out.println("Exiting the menu");
        return true;
    }

    private int getOperation() {
        printOperations();
        Integer op = getIntInput("Enter an operation number (press Enter to quit)");
        return Objects.isNull(op) ? -1 : op;
    }

    private void printOperations() {
        System.out.println();
        System.out.println("Here's what you can do:");
        operations.forEach(op -> System.out.println(op));
    }

    private Integer getIntInput(String prompt) {
        String input = getStringInput(prompt);
        if (Objects.isNull(input)) {
            return null;
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new DbException(input + " is not a number");
        }
    }

    private Double getDoubleInput(String prompt) {
        String input = getStringInput(prompt);
        if (Objects.isNull(input)) {
            return null;
        }
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new DbException(input + " is not a number");
        }
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt + ": ");
        String line = scanner.nextLine();

        return line.isBlank() ? null : line.trim();
    }
}