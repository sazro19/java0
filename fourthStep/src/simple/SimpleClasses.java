package simple;

import association.auto.Car;

import java.util.*;

public class SimpleClasses {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.printVars();
        test1.setVar1(7);
        test1.setVar2(8);
        test1.printVars();
        test1.sumVars();
        test1.greaterVar();

        line();

        Test2 test2 = new Test2(5, 10);
        Test2 test21 = new Test2();
        System.out.println(test2.getVar1() + " " + test2.getVar2());
        System.out.println(test21.getVar1() + " " + test21.getVar2());

        line();

        List<Student> students = new ArrayList<>();
        String lastname = "lastname";
        String initials = "A.B.";
        int groupNumber = 821700;

        for (int i = 1; i < 10; i++) {
            int[] marks = new int[]{new Random().nextInt(11) + 1,
                    new Random().nextInt(11) + 1,
                    new Random().nextInt(11) + 1,
                    new Random().nextInt(11) + 1,
                    new Random().nextInt(11) + 1};
            students.add(new Student(lastname + i, initials + i, groupNumber + i, marks));
        }
        students.add(new Student(lastname + (new Random().nextInt(21) + 10),
                initials + (new Random().nextInt(21) + 10),
                groupNumber + (new Random().nextInt(21) + 10),
                new int[]{10, 9, 9, 10, 9}));

        Student.printStudentsWithGoodMarks(students);

        line();

        List<Train> trains = new ArrayList<>(Arrays.asList(new Train("Minsk", 3, new Date()),
                new Train("Minsk", 4, new Date(1)),
                new Train("Albania", 1, new Date()),
                new Train("Berlin", 5, new Date())));

        Train.sortByNumber(trains);
        // Train.printInfo(trains);
        System.out.println("next");
        Train.sortByFinalPoint(trains);

        line();

        Counter counter1 = new Counter();
        System.out.println(counter1.getCount());
        Counter counter2 = new Counter(7);
        System.out.println(counter2.getCount());
        counter1.enlarge();
        counter2.reduce();
        System.out.println(counter1.getCount());
        System.out.println(counter2.getCount());
        int i = 0;
        while (i < 5) {
            counter2.enlarge();
            i++;
            System.out.println("enlarge in while loop: " + counter2.getCount());
        }

        line();

        Time time = new Time();
        time.printTime();
        time.setHours(20);
        time.setMinutes(40);
        time.setSeconds(30);
        time.printTime();
        time.changeTimeOn(2, 10, 5);
        time.printTime();

        line();

        Triangle triangle = new Triangle(new double[][]{{1, 2}, {2, 2}, {-2, -2}});
        System.out.println(triangle.area() + ", " + triangle.perimeter() + ", " +
                Arrays.toString(triangle.coordinatesOfMediansIntersection()));

        line();

    }

    public static void line() {
        System.out.println("-----------------------------------------------------");
    }
}

class Test1 {

    private int var1;

    private int var2;

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }

    public void sumVars() {
        System.out.println(var1 + var2);
    }

    public void greaterVar() {
        System.out.println(Math.max(var1, var2));
    }

    public void printVars() {
        System.out.println(var1 + " " + var2);
    }
}

class Test2 {

    private int var1;

    private int var2;

    public Test2(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public Test2() {
        var1 = 1;
        var2 = 1;
    }

    public int getVar1() {
        return var1;
    }

    public int getVar2() {
        return var2;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }
}
