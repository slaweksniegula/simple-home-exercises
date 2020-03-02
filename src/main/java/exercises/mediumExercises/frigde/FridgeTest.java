package exercises.mediumExercises.frigde;

public class FridgeTest {
    public static void main(String[] args) {

        Fridge fridge = new Fridge();
        fridge.putProduct(new Product("Ser", 300));
        fridge.putProduct(new Product("Chleb", 80));
        fridge.putProduct(new Product("Masło", 80));

        Recipe sandwich = new Recipe("Kanapka");
        sandwich.addIngredient(new Product("Ser", 300));
        sandwich.addIngredient(new Product("Chleb", 80));

        boolean hasProductForSandwich = fridge.hasProductFor(sandwich);
        System.out.println("Mam produkty na kanapkę?" + hasProductForSandwich); //zwróci true

        Recipe salad = new Recipe("Sałatka");
        salad.addIngredient(new Product("Jajko", 160));
        salad.addIngredient(new Product("Sałata", 50));
        salad.addIngredient(new Product("Ser", 300));

        Recipe salad2 = new Recipe("Sałatka2");
        salad2.addIngredient(new Product("Jajko", 160));
        salad2.addIngredient(new Product("Sałata", 50));
        salad2.addIngredient(new Product("Ser", 300));
        salad2.addIngredient(new Product("Suchar", 20));

        Recipe salad3 = new Recipe("Sałatka3");
        salad3.addIngredient(new Product("Jajko", 160));
        salad3.addIngredient(new Product("Sałata", 50));
        salad3.addIngredient(new Product("Ser", 300));
        salad3.addIngredient(new Product("Pomidor", 40));
        salad3.addIngredient(new Product("Brokuł", 60));

        Recipe salad4 = new Recipe("Sałatka4");
        salad4.addIngredient(new Product("Jajko", 160));
        salad4.addIngredient(new Product("Sałata", 50));
        salad4.addIngredient(new Product("Ser", 300));

        boolean hasProductsForSalad = fridge.hasProductFor(salad);
        System.out.println("mam produkty na sałatkę? " + hasProductsForSalad);


        Recipe[] allRecipies = {sandwich, salad, salad2, salad3, salad4};
        for (int i = 0; i < allRecipies.length; i++) {
            System.out.print(allRecipies[i].nameOfRecipe + ", ");
        }
        System.out.println();
        fridge.getRecipiesWithNbrOfIngredients(allRecipies);
        System.out.println();
fridge.getRecipiesWithNbrOfIngredients2(allRecipies);

    }

}
