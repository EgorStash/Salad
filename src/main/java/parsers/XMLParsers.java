package parsers;

import salad.Creator;
import salad.ingredients.Ingredients;
import salad.Salad;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.PropertiesUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class XMLParsers implements BestParser{

    private static final String PATH_KEY = "path.xml";

    public List<Salad> parse() throws Exception {
        String[] packagesPath = PropertiesUtil.get(PATH_KEY).split(",");
        Path path = Paths.get(packagesPath[0], packagesPath[1]);
        File file = path.toFile();
        List<Salad> salads = new ArrayList<Salad>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        // Find and create salads
        NodeList saladNodes = document.getElementsByTagName("salad");
        for (int i = 0; i < saladNodes.getLength(); i++) {
            if (saladNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element saladElement = (Element) saladNodes.item(i);
                // Create Salad from basic salad.ingredients
                Salad salad = createSaladFromBasicParameters(saladElement);
                // Choose toping salad.ingredients
                addAllTopings(saladElement, salad);
                // Add finished salad to list
                salads.add(salad);
            }
        }
        return salads;
    }

    private static Salad createSaladFromBasicParameters(Element saladElement) {
        Ingredients meat = null;
        Ingredients vegetables = null;
        Ingredients souse = null;
        // salad.Salad title
        String saladTitle = saladElement.getAttribute("title");
        // Choose basic set of salad.ingredients
        NodeList basicIngredients = saladElement.getElementsByTagName("basic");
        if (basicIngredients.item(0).getNodeType() == Node.ELEMENT_NODE) {
            Element ingredientsList = (Element) basicIngredients.item(0);
            // Find all salad.ingredients of specific salad
            NodeList ingredients = ingredientsList.getElementsByTagName("ingredient");
            for (int j = 0; j < ingredients.getLength(); j++) {
                if (ingredients.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    // Take one ingredient and work with it
                    Element ingredient = (Element) ingredients.item(j);
                    String ingredientType = ingredient.getAttribute("type");
                    if (ingredientType.equals("Meat")) {
                        meat = defineMeatParameters(ingredient);
                    } else if (ingredientType.equals("Vegetables")) {
                        vegetables = defineVegetablesParameters(ingredient);
                    } else if (ingredientType.equals("Souce")) {
                        souse = defineSouceParameters(ingredient);
                    }
                }
            }
        }
        // Create salad instance
        return Creator.createSalad(saladTitle, meat, vegetables, souse);
    }

    private static void addAllTopings(Element saladElement, Salad salad) {
        NodeList topingIngredients = saladElement.getElementsByTagName("topings");
        if (topingIngredients.item(0).getNodeType() == Node.ELEMENT_NODE) {
            Element ingredientsList = (Element) topingIngredients.item(0);
            NodeList ingredients = ingredientsList.getElementsByTagName("ingredient");
            for (int j = 0; j < ingredients.getLength(); j++) {
                if (ingredients.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element ingredient = (Element) ingredients.item(j);
                    String ingredientType = ingredient.getAttribute("type");
                    if (ingredientType.equals("Meat")) {
                        salad.addTopic(defineMeatParameters(ingredient));
                    } else if (ingredientType.equals("Vegetables")) {
                        salad.addTopic(defineVegetablesParameters(ingredient));
                    } else if (ingredientType.equals("Souce")) {
                        salad.addTopic(defineSouceParameters(ingredient));
                    }
                }
            }
        }
    }


    private static Ingredients defineMeatParameters(Element ingredient) {
        // Go through parameters
        String title = null;
        String animal = null;
        String bodyPart = null;
        int calories = 0;
        LocalDate productionDate = null;
        int validTime = 0;
        NodeList ingredientParameters = ingredient.getChildNodes();
        for (int z = 0; z < ingredientParameters.getLength(); z++) {
            if (ingredientParameters.item(z).getNodeType() == Node.ELEMENT_NODE) {
                Element parameter = (Element) ingredientParameters.item(z);
                switch (parameter.getNodeName()) {
                    case "title": {
                        title = parameter.getTextContent();
                    }
                    break;
                    case "animal": {
                        animal = parameter.getTextContent();
                    }
                    break;
                    case "bodyPart": {
                        bodyPart = parameter.getTextContent();
                    }
                    break;
                    case "calories": {
                        calories = Integer.valueOf(parameter.getTextContent());
                    }
                    break;
                    case "productionDate": {
                        productionDate = defineDateParameters(ingredient);
                    }
                    break;
                    case "validTime": {
                        validTime = Integer.valueOf(parameter.getTextContent());
                    }
                }
            }
        }
        return Creator.getSomeMeat(title, calories, productionDate, validTime, animal, bodyPart);

    }

    private static Ingredients defineVegetablesParameters(Element ingredient) {
        String title = null;
        int calories = 0;
        LocalDate productionDate = null;
        int validTime = 0;
        String type = null;
        String productionType = null;
        NodeList ingredientParameters = ingredient.getChildNodes();
        for (int z = 0; z < ingredientParameters.getLength(); z++) {
            if (ingredientParameters.item(z).getNodeType() == Node.ELEMENT_NODE) {
                Element parameter = (Element) ingredientParameters.item(z);
                switch (parameter.getNodeName()) {
                    case "title": {
                        title = parameter.getTextContent();
                    }
                    break;
                    case "type": {
                        type = parameter.getTextContent();
                    }
                    break;
                    case "productionType": {
                        productionType = parameter.getTextContent();
                    }
                    break;
                    case "calories": {
                        calories = Integer.valueOf(parameter.getTextContent());
                    }
                    break;
                    case "productionDate": {
                        productionDate = defineDateParameters(ingredient);
                    }
                    break;
                    case "validTime": {
                        validTime = Integer.valueOf(parameter.getTextContent());
                    }
                }
            }
        }
        return Creator.getSomeVegetables(title, calories, productionDate, validTime, type, productionType);
    }

    private static Ingredients defineSouceParameters(Element ingredient) {
        String title = null;
        int calories = 0;
        LocalDate productionDate = null;
        int validTime = 0;
        String sourness = null;
        String sweetness = null;
        String salty = null;
        NodeList ingredientParameters = ingredient.getChildNodes();
        for (int z = 0; z < ingredientParameters.getLength(); z++) {
            if (ingredientParameters.item(z).getNodeType() == Node.ELEMENT_NODE) {
                Element parameter = (Element) ingredientParameters.item(z);
                switch (parameter.getNodeName()) {
                    case "title": {
                        title = parameter.getTextContent();
                    }
                    break;
                    case "sourness": {
                        sourness = parameter.getTextContent();
                    }
                    break;
                    case "sweetnes": {
                        sweetness = parameter.getTextContent();
                    }
                    break;
                    case "salty": {
                        salty = parameter.getTextContent();
                    }
                    break;
                    case "calories": {
                        calories = Integer.valueOf(parameter.getTextContent());
                    }
                    break;
                    case "productionDate": {
                        productionDate = defineDateParameters(ingredient);
                    }
                    break;
                    case "validTime": {
                        validTime = Integer.valueOf(parameter.getTextContent());
                    }
                }
            }
        }
        return Creator.getSomeSouce(title, calories, productionDate, validTime, sourness, sweetness, salty);
    }

    private static LocalDate defineDateParameters(Element ingredient) {
        int year = 0;
        int month = 0;
        int day = 0;
        NodeList ingredientProductionDate = ingredient.getElementsByTagName("productionDate");
        if (ingredientProductionDate.item(0).getNodeType() == Node.ELEMENT_NODE) {
            Element productionDates = (Element) ingredientProductionDate.item(0);
            NodeList productionDatesParameters = productionDates.getChildNodes();
            for (int y = 0; y < productionDatesParameters.getLength(); y++) {
                if (productionDatesParameters.item(y).getNodeType() == Node.ELEMENT_NODE) {
                    Element productionDatesParameter = (Element) productionDatesParameters.item(y);
                    switch (productionDatesParameter.getNodeName()) {
                        case "year": {
                            year = Integer.valueOf(productionDatesParameter.getTextContent());
                        }
                        break;
                        case "month": {
                            month = Integer.valueOf(productionDatesParameter.getTextContent());
                        }
                        break;
                        case "day": {
                            day = Integer.valueOf(productionDatesParameter.getTextContent());
                        }
                    }
                }
            }
        }
        return LocalDate.of(year, month, day);
    }
}

