package salad;

import salad.Salad;
import salad.ingredients.Ingredients;
import salad.ingredients.Meat;
import salad.ingredients.Souce;
import salad.ingredients.Vegetables;

import java.time.LocalDate;

public class Creator {
    // Help to avoid class initialisation in main methods

    public static Ingredients getSomeMeat(String title, int calories, LocalDate createdDate, int validTime, String animal, String bodyPart) {
        return (Ingredients) new Meat(title, calories, createdDate, validTime, animal, bodyPart);
    }

    public static Ingredients getSomeVegetables(String title, int calories, LocalDate createdDate, int validTime, String type, String productionType) {
        return (Ingredients) new Vegetables(title, calories, createdDate, validTime, type, productionType);
    }

    public static Ingredients getSomeSouce(String title, int calories, LocalDate createdDate, int validTime, String sourness, String sweetness, String salty) {
        return (Ingredients) new Souce(title, calories, createdDate, validTime, sourness, sweetness, salty);
    }

    public static Salad createSalad(String title, Ingredients meat, Ingredients vegetables, Ingredients souce) {
        return new Salad(title, meat, vegetables, souce);
    }
}
