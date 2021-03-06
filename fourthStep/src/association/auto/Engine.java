package association.auto;

public class Engine {

    private boolean isOk = true;

    boolean on() {
        double rand = Math.random();
        isOk = rand > 0.5;
        if (isOk) {
            System.out.println("Engine is working");
        } else {
            System.out.println("Engine is broke");
        }
        return isOk;
    }

    void repair() {
        isOk = true;
    }
}
