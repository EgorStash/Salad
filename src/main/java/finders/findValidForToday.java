package finders;

import salad.Salad;

import java.util.ArrayList;
import java.util.List;

public class findValidForToday implements Findable {
    @Override
    public List<Salad> find(List<Salad> salads) {
        ArrayList<Salad> finded = new ArrayList<Salad>();
        for (Salad salad : salads) {
            if (salad.validForTooday()) {
                finded.add(salad);
            }
        }
        return finded;
    }
}
