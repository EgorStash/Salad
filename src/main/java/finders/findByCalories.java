package finders;

import salad.Salad;

import java.util.ArrayList;
import java.util.List;

public class findByCalories implements Findable {
    // Help to find salads with calories less than proposed.
    private int calories;

    public findByCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public List<Salad> find(List<Salad> salads) {
        List<Salad> finded = new ArrayList<Salad>();
        for(Salad salad : salads){
            if(salad.countCalories() < this.calories){
                finded.add(salad);
            }
        }
        return finded;
    }

}
