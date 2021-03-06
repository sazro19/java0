package association.country;

import java.util.*;

public class Country {

    private String name;

    private double area;

    private Set<Region> regionSet = new HashSet<>();

    private City capital;

    public Country(String name, double area, Set<Region> regionSet, City capital) {
        this.regionSet = regionSet;
        try {
            if (!isCapitalExist(capital)) {
                throw new IllegalArgumentException("Can't find capital in regions");
            } else {
                this.capital = capital;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            capital = null;
        } finally {
            this.name = name;
            this.area = area;
        }
    }

    public void printCapital() {
        System.out.println(capital.getName());
    }

    public void printRegionNumber() {
        System.out.println(regionSet.size());
    }

    public void printArea() {
        System.out.println(area);
    }

    public void printRegionalCentres() {
        for (Region region : regionSet) {
            System.out.println(region.getRegionCenter().getName());
        }
    }

    private boolean isCapitalExist(City capital) {
        for (Region region : regionSet) {
            if (region.getCitySet().contains(capital)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashSet<District> districts = new HashSet<>(Arrays.asList(new District("1"), new District("2"), new District("2")));
        HashSet<District> districts1 = new HashSet<>(Arrays.asList(new District("3"), new District("4")));
        HashSet<District> districts2 = new HashSet<>(Arrays.asList(new District("5"), new District("6")));
        HashSet<City> cities = new HashSet<>(Arrays.asList(new City("M", districts), new City("N", districts1)));
        HashSet<City> cities1 = new HashSet<>(Collections.singletonList(new City("O", districts2)));
        HashSet<Region> regions = new HashSet<>(Arrays.asList(new Region("r1", cities, new City("M", districts)), new Region("r2", cities1, new City("O", districts2))));
        Country country = new Country("C", 545, regions, new City("O", districts2));
        country.printArea();
        country.printRegionalCentres();
        country.printCapital();
        country.printRegionNumber();
    }
}
