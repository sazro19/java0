package association.auto;

import java.util.Scanner;

public class Car {

    private String mark;

    private int patrol = 5;

    private Engine engine = new Engine();

    private Wheel[] wheels = new Wheel[]{new Wheel(), new Wheel(), new Wheel(), new Wheel()};

    public Car(String mark) {
        this.mark = mark;
    }

    public static void main(String[] args) {
        Car car = new Car("Audi");
        while (true) {
            int i = new Scanner(System.in).nextInt();
            switch (i){
                case 1:
                    car.drive();
                    break;
                case 2:
                    car.refuel();
                    break;
                case 3:
                    car.printMark();
                    break;
                case 4:
                    int j = new Scanner(System.in).nextInt();
                    car.changeWheel(j);
                    break;
                case 5:
                    car.engine.repair();
            }
        }
    }

    public void drive() {
        if (isWheelsOk() && engine.on() && isPatrol()) {
            patrol--;
            System.out.println("потрачена единица бензина, едим на мид");
        }
    }

    public void refuel() {
        patrol = 5;
    }

    public void changeWheel(int i) {
        wheels[i] = new Wheel();
    }

    public void printMark() {
        System.out.println("Марка: " + mark);
    }

    private boolean isWheelsOk() {
        for (int i = 0; i < wheels.length; i++) {
            if (!wheels[i].isOk()) {
                System.out.println(i + " колесо повреждено");
                return false;
            }
        }
        return true;
    }

    private boolean isPatrol() {
        if (patrol > 0) {
            return true;
        }
        System.out.println("Нет бензина");
        return false;
    }
}
