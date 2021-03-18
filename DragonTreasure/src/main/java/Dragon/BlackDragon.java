package Dragon;

public class BlackDragon extends Dragon {

    public BlackDragon(String name, int level) {
        this.name = name;
        this.level = calcDangerousLevel(level);
    }

    @Override
    protected int calcDangerousLevel(int level) {
        return (int)(level * 1.5);
    }
}
