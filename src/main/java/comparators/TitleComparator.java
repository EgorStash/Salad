package comparators;

import salad.Salad;

import java.util.Comparator;

public class TitleComparator implements Comparator<Salad> {
    // Comparator to sort by Title parameter

    @Override
    public int compare(Salad o1, Salad o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
