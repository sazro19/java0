package Dragon;

public class RedDragon extends Dragon {

    public RedDragon(String name, int level) {
        this.name = name;
        this.level = calcDangerousLevel(level);
    }

    @Override
    protected int calcDangerousLevel(int level) {
        return level;
    }
}
