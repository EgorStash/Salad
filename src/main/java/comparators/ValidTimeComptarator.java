package comparators;

import salad.Salad;

import java.util.Comparator;

public class ValidTimeComptarator implements Comparator<Salad> {
    // Comparator to sort by validTime parameter

    @Override
    public int compare(Salad o1, Salad o2) {
        if (o1.validTimeForSalad() < o2.validTimeForSalad()) {
            return -1;
        } else if (o1.validTimeForSalad() > o2.validTimeForSalad()) {
            return 1;
        } else {
            return 0;
        }
    }
}
