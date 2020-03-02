package exercises.mediumExercises.frigde;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fridge {

    List<Product> products = new ArrayList<Product>();

    public void putProduct(Product product) {
        products.add(product);
    }

    public boolean hasProductFor(Recipe recipe) {
        for (Product product : recipe.getIngredients()) {
            if (!products.contains(product)) {
                return false;
            }
        }
        return true;
    }

    public int getRecipeCalories(Recipe recipe) {
        int recipeCalories = 0;
        for (Product product : recipe.getIngredients()) {
            recipeCalories += product.getCalorie();
        }
        return recipeCalories;
    }

    public static void getRecipiesWithNbrOfIngredients(Recipe[] allRecipies) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Z ilu składników chcesz zrobić danie? :");
        int customerNbrOfIngredients = scanner.nextInt();

        Recipe[] matchingRecepies = new Recipe[allRecipies.length];
        int position = 0;
        for (int i = 0; i < allRecipies.length; i++) {
            if (allRecipies[i].getNumberOfIngredients(allRecipies[i]) == customerNbrOfIngredients) {
                matchingRecepies[position] = allRecipies[i];
                position++;
            }
        }
        for (Recipe r : matchingRecepies) {
            if (r != null) {
                System.out.println(r.nameOfRecipe);
            }
        }
    }

    public static void getRecipiesWithNbrOfIngredients2(Recipe[] allRecipies) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Z ilu składników chcesz zrobić danie? :");
        int customerNbrOfIngredients = scanner.nextInt();

        List<String> matchingRecepies2 = new ArrayList<String>();
        for (int i = 0; i < allRecipies.length; i++) {
            if (customerNbrOfIngredients == allRecipies[i].getNumberOfIngredients(allRecipies[i])) {
                matchingRecepies2.add(allRecipies[i].nameOfRecipe);
            }
        }
        System.out.println(matchingRecepies2);
    }
}