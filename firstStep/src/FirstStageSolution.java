import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class FirstStageSolution {

    public static void main(String[] args) throws IOException {
        System.out.println(function1(5., 3., 4.));
        System.out.println(function2(5., 3., 4.));
        System.out.println(function3(5., 3.));
        System.out.println(change(333.999));
        System.out.println(timeFormatter(200));
        System.out.println(pointInArea(-5, 1));
        System.out.println(isTriangleExisting(170, 60));
        System.out.println(function4(5., 2., 4., 1.));
        System.out.println(threePoints(1., 2., 3., 4., 5., 6.));
        System.out.println(hole(1., 2., 3., 4., 5.));
        System.out.println(function5(6.));
        //System.out.println(sum());
        sumOnSegment(0., 4., 0.5);
        System.out.println(sumOfSquares());
        System.out.println(multiplicationOfSquares());
        System.out.println(sumOfRow(0.1));
        symbolsInComputer();
        //dividers();
        findCommonFigures(123, 34);

    }

    public static double function1(double a, double b, double c){
        return ((a - 3) * b / 2) + c;
    }

    public static double function2(double a, double b, double c){
        return (((b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a)) - Math.pow(a, 3) * c + Math.pow(b, -2));
    }

    public static double function3(double x, double y){
        return ((Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y))) * Math.tan(x*y);
    }

    public static double change(double x){
        double a = x * 1000;
        int b = (int) a % 1000;
        return b + ((int) x / 1000.);
    }

    public static String timeFormatter(int timeInSec){
        if (timeInSec <= 0){
            throw new IllegalArgumentException("Значение времени не может быть отрицательным или ноль");
        }
        int timeInHours = timeInSec / 3600;
        timeInSec %= 3600;
        int timeInMinutes = timeInSec / 60;
        timeInSec %= 60;
        return timeInHours + "ч " + timeInMinutes + "м " + timeInSec + "с";
    }

    public static boolean pointInArea(double x, double y){
        return ((x >= -2 & x <= 2) & (y >= 0 & y <= 4)) |
                ((x >= -4 & x <= 4) & (y >= -3 & y <= 0)) &
                (x != 0 & y != -1);
    }

    public static String isTriangleExisting(int a, int b){
        if (a <= 0 || b <= 0){
            throw new IllegalArgumentException("Значения углов треугольника в градусах должны быть положительными");
        }
        if (a + b >= 180){
            return "Треугольник не существует";
        }
        if (a == 90 || b == 90 || 180 - a - b == 90){
            System.out.println("Треугольник является прямоугольным");
        }
        return "Треугольник существует";
    }

    public static double function4(double a, double b, double c, double d){
        double first;
        double second;
        if (a <= b){
            first = a;
        } else {
            first = b;
        }
        if (c <= d){
            second = c;
        } else {
            second = d;
        }
        if (first <= second){
            return second;
        } else {
            return first;
        }
    }

    public static boolean threePoints(double x1, double y1, double x2, double y2, double x3, double y3){
        return  (((x3 - x1) / (x2 - x1)) == ((y3 - y1) / (y2 - y1)));
    }

    public static boolean hole(double a, double b, double x, double y, double z){
        return !(x > b) && !(y > b);
    }

    public static double function5(double x){
        if (x <= 3){
            return Math.pow(x, 2) - 3*x + 9;
        } else {
            return 1 / (Math.pow(x, 3) + 6);
        }
    }

    public static int sum() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x <= 0){
            throw new IllegalArgumentException("x должен быть положительным");
        }
        int sum = 0;
        for(int i = 1; i <= x; i++){
            sum += i;
        }
        return sum;
    }

    public static void sumOnSegment(double a, double b, double h){
        for (double i = a; i <= b; i += h){
            if (i > 2){
                System.out.println("x = " + i + ", y = " + i);
            } else {
                System.out.println("x = " + i + ", y = " + -i);
            }
        }
    }

    public static int sumOfSquares(){
        int sum = 0;
        for (int i = 1; i <= 100; i++){
            sum += i*i;
        }
        return sum;
    }

    public static BigInteger multiplicationOfSquares(){
        BigInteger multiplication = BigInteger.valueOf(1);
        for (int i = 1; i <= 200; i++){
            multiplication = multiplication.multiply(BigInteger.valueOf((long) i*i));
        }
        return multiplication;
    }

    public static double sumOfRow(double e){
        double sum = 0;
        double temp;
        for (int i = 1; ; i++){
            temp = Math.abs((1 / Math.pow(2, i)) + (1 / Math.pow(3, i)));
            if (Math.abs(temp) >= e){
                sum += temp;
            }
            if (temp == 0.){
                break;
            }
        }
        return sum;
    }

    public static void symbolsInComputer(){
        for (int i = 0; i <= 255; i++){
            System.out.println(i + " - " + (char) i);
        }
    }

    public static void dividers(){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        if (m <= 0 || n <= 0){
            throw new IllegalArgumentException("Значения должны быть натуральными");
        }
        for (int i = m; i <= n; i++){
            for (int j = 2; j < i; j++){
                if (i % j == 0){
                    System.out.println("Делитель " + i + ": " + j);
                }
            }
        }
    }

    public static void findCommonFigures(int m, int n){
        for (int i = m; i > 0; i /= 10){
            int tempI = i % 10;
            for (int j = n; j > 0; j /= 10){
                int tempJ = j % 10;
                if (tempI == tempJ){
                    System.out.println("Общая цифра: " + tempI);
                }
            }
        }
    }
}
