package association.auto;

public class Wheel {

    private boolean isOk = true;

    private int health = 6;

    boolean isOk() {
        if (health > 0) {
            health--;
            isOk = true;
        } else {
            isOk = false;
        }
        return isOk;
    }
}
