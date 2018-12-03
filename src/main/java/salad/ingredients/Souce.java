package salad.ingredients;

import java.time.LocalDate;
import java.util.Objects;

public class Souce extends Ingredients {

    private String sourness;
    private String sweetness;
    private String salty;

    public Souce(String title, int calories, LocalDate createdDate, int validTime, String sourness, String sweetness, String salty) {
        super(title, calories, createdDate, validTime);
        this.sourness = sourness;
        this.sweetness = sweetness;
        this.salty = salty;
    }

    public String getSourness() {
        return sourness;
    }

    public void setSourness(String sourness) {
        this.sourness = sourness;
    }

    public String getSweetness() {
        return sweetness;
    }

    public void setSweetness(String sweetness) {
        this.sweetness = sweetness;
    }

    public String getSalty() {
        return salty;
    }

    public void setSalty(String salty) {
        this.salty = salty;
    }

    @Override
    public String toString() {

        return "salad.ingredients.Souce{" +
                "title='" + getTitle() + '\'' +
                ", sourness='" + getSourness() + '\'' +
                ", sweetness='" + getSweetness() + '\'' +
                ", salty='" + getSalty() + '\'' +
                ", calories=" + getCalories() +
                ", createdDate=" + getCreatedDate() +
                ", validTime=" + getValidTime() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Souce souce = (Souce) o;
        return Objects.equals(sourness, souce.sourness) &&
                Objects.equals(sweetness, souce.sweetness) &&
                Objects.equals(salty, souce.salty);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sourness, sweetness, salty);
    }
}
