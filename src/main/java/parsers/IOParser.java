package parsers;

import salad.Creator;
import salad.ingredients.Ingredients;
import salad.Salad;
import util.PropertiesUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOParser implements BestParser {

    private static final String PATH_KEY = "path.io";

    @Override
    public List<Salad> parse() throws Exception {
        String[] packagesPath = PropertiesUtil.get(PATH_KEY).split(",");
        Path path = Paths.get(packagesPath[0], packagesPath[1]);
        List<Salad> salads = new ArrayList<>();
        try {
            List<String> list = new ArrayList<String>();
            Files.lines(path, StandardCharsets.UTF_8).forEach(s -> list.add(s));
            for (String line : list) {
                String[] characteristics = line.split(", ");
                Salad salad = consolidate(characteristics);
                salads.add(salad);
            }
        } catch (ArithmeticException e) {
            System.out.println("Warning: ArithmeticException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Warning: ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println("Warning: Some Other exception");
            e.printStackTrace();
        } finally {
            System.out.println("Reading done!");
        }
        return salads;
    }


    public static Salad consolidate(String[] characteristics) {
        String saladTitle = characteristics[0];
        Ingredients meat = null;
        Ingredients vegetables = null;
        Ingredients souce = null;
        for (String characteristic : characteristics) {
            if (characteristic.contains("Meat")) {
                String[] meatCharacteristics = characteristic.split(":");
                String title = meatCharacteristics[1];
                int calories = Integer.valueOf(meatCharacteristics[2]);
                int day = Integer.valueOf(meatCharacteristics[3]);
                int month = Integer.valueOf(meatCharacteristics[4]);
                int year = Integer.valueOf(meatCharacteristics[5]);
                int validTime = Integer.valueOf(meatCharacteristics[6]);
                String animal = meatCharacteristics[7];
                String bodyPart = meatCharacteristics[8];
                meat = Creator.getSomeMeat(title, calories, LocalDate.of(year, month, day), validTime, animal, bodyPart);
            } else if (characteristic.contains("Vegetables")) {
                String[] meatCharacteristics = characteristic.split(":");
                String title = meatCharacteristics[1];
                int calories = Integer.valueOf(meatCharacteristics[2]);
                int day = Integer.valueOf(meatCharacteristics[3]);
                int month = Integer.valueOf(meatCharacteristics[4]);
                int year = Integer.valueOf(meatCharacteristics[5]);
                int validTime = Integer.valueOf(meatCharacteristics[6]);
                String type = meatCharacteristics[7];
                String productionType = meatCharacteristics[8];
                vegetables = Creator.getSomeVegetables(title, calories, LocalDate.of(year, month, day), validTime, type, productionType);
            } else if (characteristic.contains("Souce")) {
                String[] meatCharacteristics = characteristic.split(":");
                String title = meatCharacteristics[1];
                int calories = Integer.valueOf(meatCharacteristics[2]);
                int day = Integer.valueOf(meatCharacteristics[3]);
                int month = Integer.valueOf(meatCharacteristics[4]);
                int year = Integer.valueOf(meatCharacteristics[5]);
                int validTime = Integer.valueOf(meatCharacteristics[6]);
                String sourness = meatCharacteristics[7];
                String sweetness = meatCharacteristics[8];
                String salty = meatCharacteristics[9];
                souce = Creator.getSomeSouce(title, calories, LocalDate.of(year, month, day), validTime, sourness, sweetness, salty);
            }
        }
        return Creator.createSalad(saladTitle, meat, vegetables, souce);
    }


    public static void writeSmth(File file, String smth) throws FileNotFoundException, IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(smth + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readSmth(File file) throws FileNotFoundException, IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
//            bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
