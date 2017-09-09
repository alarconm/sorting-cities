package org.launchcode.comparators;

import org.launchcode.City;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator implements Comparator<City> {

    List<Comparator<City>> comparators = new ArrayList<>();

    @Override
    public int compare(City o1, City o2) {

        if (comparators.size() < 2) {
            return comparators.get(0).compare(o1, o2);
        }

        int count = 0;

        while ( comparators.get(count).compare(o1, o2) == 0) {
            count++;
        }

        return comparators.get(count).compare(o1, o2);

    }

    public void add (Comparator<City> comparator) {
        comparators.add(comparator);
    }
}
