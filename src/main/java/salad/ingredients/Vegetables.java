package salad.ingredients;

import java.time.LocalDate;
import java.util.Objects;

public class Vegetables extends Ingredients {

    private String type;
    private String productionType;

    public Vegetables(String title, int calories, LocalDate createdDate, int validTime, String type, String productionType) {
        super(title, calories, createdDate, validTime);
        this.type = type;
        this.productionType = productionType;
    }

    private static boolean isItNatural(String productionType) {
        // Check if vegetables for salad was raised natural or not
        if (productionType.equals("natural")) {
            return true;
        }
        return false;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductionType() {
        return productionType;
    }

    public void setProductionType(String productionType) {
        this.productionType = productionType;
    }

    @Override
    public String toString() {
        return "salad.ingredients.Vegetables{" +
                "title='" + getTitle() + '\'' +
                ", type='" + getType() + '\'' +
                ", productionType='" + getProductionType() + '\'' +
                ", calories=" + getCalories() +
                ", createdDate=" + getCreatedDate() +
                ", validTime=" + getValidTime() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vegetables that = (Vegetables) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(productionType, that.productionType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, productionType);
    }
}
