package salad;

import salad.ingredients.Ingredients;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Salad implements Comparable<Salad> {

    private String title;
    private Ingredients meat;
    private Ingredients vegetables;
    private Ingredients souce;
    private List<Ingredients> topics = new ArrayList<Ingredients>();

    public Salad(String title, Ingredients meat, Ingredients vegetables, Ingredients souce) {
        this.title = title;
        this.meat = meat;
        this.vegetables = vegetables;
        this.souce = souce;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int countCalories() {
        int calories = this.meat.getCalories() + this.vegetables.getCalories() + this.souce.getCalories();
        if (this.topics.size() > 0) {
            for (Ingredients topic : topics) {
                calories += topic.getCalories();
            }
        }
        return calories;
    }

    public int validTimeForSalad() {
        // Check for minimal value for valid time for salad.ingredients.
        int min = meat.getValidTime();
        if (vegetables.getValidTime() < min) {
            min = vegetables.getValidTime();
        } else if (souce.getValidTime() < min) {
            min = souce.getValidTime();
        }
        if (this.topics.size() > 0) {
            for (Ingredients topic : topics) {
                if (topic.getValidTime() < min) {
                    min = topic.getValidTime();
                }
            }
        }
        return min;
    }

    public LocalDate validDate() {
        // Help to find valid Date according to Creation date and valid time
        LocalDate meatValidDate = meat.getCreatedDate().plusDays(meat.getValidTime());
        LocalDate vegetablesValidDate = vegetables.getCreatedDate().plusDays(vegetables.getValidTime());
        LocalDate souceValidDate = souce.getCreatedDate().plusDays(souce.getValidTime());
        LocalDate validTime = meatValidDate;
        if (vegetablesValidDate.isBefore(validTime)) {
            validTime = vegetablesValidDate;
        } else if (souceValidDate.isBefore(validTime)) {
            validTime = souceValidDate;
        }
        if (this.topics.size() > 0) {
            for (Ingredients topic : topics) {
                LocalDate topicValidTime = topic.getCreatedDate().plusDays(topic.getValidTime());
                if (topicValidTime.isBefore(validTime)) {
                    validTime = topicValidTime;
                }
            }
        }
        return validTime;
    }

    public boolean validForTooday() {
        // Checking if salad valid for today
        LocalDate today = LocalDate.now();
        if (validDate().isBefore(today)) {
            return false;
        }
        return true;
    }

    public void addTopic(Ingredients additionalTopic) {
        // Add toping for your salad, in case if you want it.
        topics.add(additionalTopic);
    }

    @Override
    public String toString() {
        return "Salad " +
                '{' + "\n" +
                "Title: " + title + "\n" +
                meat + "\n" +
                vegetables + "\n" +
                souce + "\n" +
                "Topics: " + topics + "\n" +
                "Calories: " + countCalories() + "\n" +
                "Salad Valid Time: " + validTimeForSalad() + "\n" +
                "And Valid till: " + validDate() + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salad salad = (Salad) o;
        return Objects.equals(title, salad.title) &&
                Objects.equals(meat, salad.meat) &&
                Objects.equals(vegetables, salad.vegetables) &&
                Objects.equals(souce, salad.souce) &&
                Objects.equals(topics, salad.topics);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, meat, vegetables, souce, topics);
    }

    // Sort by calories by default sort
    @Override
    public int compareTo(Salad anotherSalad) {
        int anotherSaladCalories = anotherSalad.countCalories();
        return countCalories() - anotherSaladCalories;
    }
}
