package finders;

import salad.Salad;

import java.util.ArrayList;
import java.util.List;

public class findByValidDuration implements Findable {
    // Help to find salads which got Valid Time more than proposed.
    private int validTime;

    public findByValidDuration(int validTime) {
        this.validTime = validTime;
    }

    @Override
    public List<Salad> find(List<Salad> salads) {
        List<Salad> finded = new ArrayList<Salad>();
        for (Salad salad : salads) {
            if (salad.validTimeForSalad() > this.validTime) {
                finded.add(salad);
            }
        }
        return finded;
    }
}
