package association.country;

import java.util.*;

public class Region {

    private String name;

    private Set<City> citySet = new HashSet<>();

    private City regionCenter;

    public Region(String name, Set<City> citySet, City regionCenter) {
        this.name = name;
        this.citySet = citySet;
        this.regionCenter = regionCenter;
        citySet.add(regionCenter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return name.equals(region.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<City> getCitySet() {
        return citySet;
    }

    public void setCitySet(Set<City> citySet) {
        this.citySet = citySet;
    }

    public City getRegionCenter() {
        return regionCenter;
    }

    public void setRegionCenter(City regionCenter) {
        this.regionCenter = regionCenter;
    }
}
