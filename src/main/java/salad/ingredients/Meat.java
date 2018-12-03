package salad.ingredients;

import java.time.LocalDate;
import java.util.Objects;

public class Meat extends Ingredients {

    private String animal;
    private String bodyPart;

    public Meat(String title, int calories, LocalDate createdDate, int validTime, String animal, String bodyPart) {
        super(title, calories, createdDate, validTime);
        this.animal = animal;
        this.bodyPart = bodyPart;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return "salad.ingredients.Meat{" +
                "title='" + getTitle() + '\'' +
                ", animal='" + getAnimal() + '\'' +
                ", bodyPart='" + getBodyPart() + '\'' +
                ", calories=" + getCalories() +
                ", createdDate=" + getCreatedDate() +
                ", validTime=" + getValidTime() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meat meat = (Meat) o;
        return Objects.equals(animal, meat.animal) &&
                Objects.equals(bodyPart, meat.bodyPart);
    }

    @Override
    public int hashCode() {

        return Objects.hash(animal, bodyPart);
    }
}
