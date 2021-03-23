package Treasure;

public class Jewel {

    private final String name;

    private final double cost;

    public Jewel(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name;
    }
}