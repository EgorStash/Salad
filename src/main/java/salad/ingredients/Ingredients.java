package salad.ingredients;

import java.time.LocalDate;

public abstract class Ingredients {
    // Ingredients parent class for all salad.ingredients in Salad class

    private String title;
    private int calories;
    private LocalDate createdDate;
    private int validTime;

    public Ingredients(String title, int calories, LocalDate createdDate, int validTime) {
        this.title = title;
        this.calories = calories;
        this.createdDate = createdDate;
        this.validTime = validTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public int getValidTime() {
        return validTime;
    }

    public void setValidTime(int validTime) {
        this.validTime = validTime;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "title='" + title + '\'' +
                ", calories=" + calories +
                ", createdDate=" + createdDate +
                ", validTime=" + validTime +
                '}';
    }
}
