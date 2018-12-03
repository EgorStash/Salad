package main;

import comparators.TitleComparator;
import comparators.ValidTimeComptarator;
import exceptions.TooMuchCaloriesException;
import finders.Findable;
import finders.findByCalories;
import finders.findValidForToday;
import salad.Creator;
import salad.ingredients.Ingredients;
import menu.SaladMenu;
import parsers.BestParser;
import parsers.DBParser;
import parsers.IOParser;
import salad.Salad;
import parsers.XMLParsers;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception{
        SaladMenu menu = SaladMenu.getInstance();

        BestParser xmlParser = new XMLParsers();
        BestParser ioParser = new IOParser();
        BestParser dbParser = new DBParser();

        menu.addSalad(xmlParser.parse());   // two
        menu.addSalad(ioParser.parse());   // one
        menu.addSalad(dbParser.parse());    // two

        List<Salad> salads = menu.getSalads();
        for(Salad salad: salads){
            System.out.println(salad);
        }

        System.out.println("DefaultCalories");
        Collections.sort(salads);
        for (Salad salad : salads) {
            System.out.println(salad);
        }
        Comparator titleComparator = new TitleComparator();
        Collections.sort(salads, titleComparator);
        System.out.println("titleComparator");
        for (Salad salad : salads) {
            System.out.println(salad);
        }
        Comparator validTimeComparator = new ValidTimeComptarator();
        Collections.sort(salads, validTimeComparator);
        System.out.println("validTimeComparator");
        for (Salad salad : salads) {
            System.out.println(salad);
        }

        Findable findByCalories = new findByCalories(200);
        System.out.println("Salad's which got less than (n) calories");
        List<Salad> finded = findByCalories.find(salads);
        for (Salad salad : finded) {
            menu.addSalad(salad);
            System.out.println(salad);
        }

        Findable findValidForToday = new findValidForToday();
        System.out.println("Salad's which valid for today");
        List<Salad> findedForToday = findValidForToday.find(salads);
        for (Salad salad : findedForToday) {
            menu.addSalad(salad);
            System.out.println(salad);
        }




        // Just check Exception
        Ingredients meat = Creator.getSomeMeat("Chicken leg", 210, LocalDate.of(2020, 9, 20), 5, "Chiken", "leg");
        Ingredients vegetable = Creator.getSomeVegetables("Cucomber", 15, LocalDate.of(2020, 9, 24), 5, "cucumer", "natural");
        Ingredients souce = Creator.getSomeSouce("Carbonara", 115, LocalDate.of(2020, 9, 21), 2, "low", "low", "none");
        Salad cesar = new Salad("cesar", meat, vegetable, souce);
        Ingredients meatTopic = Creator.getSomeMeat("Chicken brest", 160, LocalDate.of(2020, 9, 20), 5, "Chiken", "brest");
        cesar.addTopic(meatTopic);
        try {
            if (cesar.countCalories() > 400) {
                throw new TooMuchCaloriesException();
            }
        } catch (TooMuchCaloriesException e) {
            e.printStackTrace();
        }
    }
}
