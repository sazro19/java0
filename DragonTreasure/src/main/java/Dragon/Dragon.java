package Dragon;

public abstract class Dragon {

    protected String name;

    protected int level;

    protected abstract int calcDangerousLevel(int level);

    public int getLevel() {
        return level;
    }
}
