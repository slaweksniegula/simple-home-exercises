package exercises.mediumExercises.frigde;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    public String nameOfRecipe;

    public Recipe(String nameOfRecipe) {
        this.nameOfRecipe = nameOfRecipe;
    }

    List<Product> ingredients = new ArrayList<Product>();

    public List<Product> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Product product){
        ingredients.add(product);
    }

    public String getNameOfRecipe() {
        return nameOfRecipe;
    }

    public int getNumberOfIngredients(Recipe recipe){
        int numberOfIngredients = recipe.ingredients.size();
        return numberOfIngredients;
    }

}
