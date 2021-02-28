package SimpleClasses;

public class Counter {

    private final int MIN = 0;

    private final int MAX = 10;

    private int count;

    public Counter() {
        count = 1;
    }

    public Counter(int count) {
        if (count > MAX || count < MIN) {
            this.count = MIN;
        } else {
            this.count = count;
        }
    }

    public void enlarge() {
        if (count == MAX) {
            count = MIN;
        } else {
            count++;
        }
    }

    public void reduce() {
        if (count > MIN) {
            count--;
        } else {
            count = MIN;
        }
    }

    public int getCount() {
        return count;
    }
}
