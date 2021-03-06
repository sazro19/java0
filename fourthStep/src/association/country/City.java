package association.country;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class City {

    private String name;

    private Set<District> districtSet = new HashSet<>();

    public City(String name, Set<District> districtList) {
        this.name = name;
        this.districtSet = districtList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return name.equals(city.name);
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

    public Set<District> getDistrictSet() {
        return districtSet;
    }

    public void setDistrictSet(Set<District> districtSet) {
        this.districtSet = districtSet;
    }
}
