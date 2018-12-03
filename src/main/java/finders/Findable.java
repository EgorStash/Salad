package finders;

import salad.ingredients.Ingredients;
import salad.Salad;

import java.util.List;

public interface Findable {
    List<Salad> find(List<Salad> salads);
}
