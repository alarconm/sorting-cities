package org.launchcode;

import org.launchcode.comparators.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<City> cities = CityData.loadData();

        // TODO - Use different comparators here
//        NameComparator comparator = new NameComparator();
//        cities.sort(comparator);

//        StateComparator comparator = new StateComparator();
//        cities.sort(comparator);

//        PopulationComparator comparator = new PopulationComparator();
//        cities.sort(comparator);

//        AreaComparator comparator = new AreaComparator();
//        cities.sort(comparator);

        CompoundComparator comparator = new CompoundComparator();
        comparator.add(new StateComparator());
        comparator.add(new PopulationComparator());
        comparator.add(new NameComparator());

        cities.sort(comparator);

        printCities(cities);

    }

    private static void printCities(ArrayList<City> cities) {

        System.out.println(City.getTableHeader());

        for(City c : cities) {
            System.out.println(c);
        }

    }
}
