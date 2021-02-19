public class MethodsPart {

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static int gcd(int first, int second, int third, int fourth) {
        int[] inputs = new int[]{first, second, third, fourth};
        int result = inputs[0];
        for (int i = 1; i < inputs.length; i++) {
            result = gcd(result, inputs[i]);
        }
        return result;
    }

    public static void areaOfRegularHexagon(double a) {
        System.out.println(6 * areaOfRegularTriangle(a));
    }

    private static double areaOfRegularTriangle(double a) {
        return (a * a * Math.sqrt(3) / 4);
    }

    public static void maxDistanceBetweenDots(double[][] dots) {
        double maxDistance = distanceBetweenDots(dots[0], dots[1]);
        double[][] result = new double[][]{dots[0], dots[1]};
        for (int i = 0; i < dots.length; i++) {
            for (int j = i; j < dots.length; j++) {
                if (maxDistance < distanceBetweenDots(dots[i], dots[j])) {
                    maxDistance = distanceBetweenDots(dots[i], dots[j]);
                    result[0] = dots[i];
                    result[1] = dots[j];
                }
            }
        }
        System.out.println("Точки: ");
        MatrixPart.printMatrix(result);
    }

    private static double distanceBetweenDots(double[] firstDot, double[] secondDot) {
        return Math.sqrt(Math.pow(secondDot[0] - firstDot[0], 2) +
                Math.pow(secondDot[1] - firstDot[1], 2));
    }

    public static void findSecondMax(double[] array) {
        array[findMaxIndex(array)] = Double.MIN_VALUE;
        System.out.println(array[findMaxIndex(array)]);
    }

    private static int findMaxIndex(double[] array) {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[maxIndex] < array[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void isCoprimeNumbers(int a, int b, int c) {
        if (gcd(new int[]{a, b, c}) == 1) {
            System.out.println(a + ", " + b + ", " + c + " ялвяются взаимно простыми числами");
        } else {
            System.out.println(a + " и " + b + ", " + c + " не ялвяются взаимно простыми числами");
        }
    }

    private static int gcd(int[] inputs) {
        int result = inputs[0];
        for (int i = 1; i < inputs.length; i++) {
            result = gcd(result, inputs[i]);
        }
        return result;
    }

    public static void sumFactorials() {
        int sum = 0;
        for (int i = 1; i < 10; i += 2) {
            sum += factorial(i);
        }
        System.out.println(sum);
    }

    private static int factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    public static void sumOfThree(int[] array, int k, int m) {
        if (m - k != 2) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int i = k - 1; i < m; i++) {
            sum += array[i];
        }
        System.out.println(sum);
    }

    public static void areaOfQuadrangle(double x, double y, double z, double t) {
        double diagonal = Math.sqrt(x * x + y * y);
        double areaOfTriangle = 0.5 * x * y;
        double halfPerimeter = 0.5 * (diagonal + t + z);
        double areaOfAnotherTriangle = Math.sqrt(halfPerimeter * (halfPerimeter - diagonal) *
                (halfPerimeter - t) * (halfPerimeter - z));
        System.out.println("Периметр: " + (areaOfTriangle + areaOfAnotherTriangle));
    }

    public static void createArrayFromN(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        int size = 0;
        int del = 1;
        do {
            size++;
            del *= 10;
        } while (n % del != n);
        int[] array = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            array[i] = n % 10;
            n /= 10;
        }
        System.out.println("Массив из " + size + " элементов:");
        SortPart.printArray(array);
    }

    public static void compareAmountOfFigures(int first, int second) {
        while (true) {
            first /= 10;
            second /= 10;
            if (first == 0 && second != 0) {
                System.out.println("Во втором числе цифр больше");
                break;
            } else if (second == 0 && first != 0) {
                System.out.println("В первом числе цифр больше");
                break;
            } else if (first == 0 && second == 0) {
                System.out.println("В числах одинаковое количество цифр");
                break;
            }
        }
    }

    public static void createArrayFromKAndN(int k, int n) {
        int[] array = new int[10000];
        int count = 0;
        int index = 0;
        for (int i = 0; i <= n; i++) {
            int sum = 0;
            for (int j = i; j > 0; j /= 10) {
                sum += j % 10;
            }
            if (sum == k) {
                array[index++] = i;
                count++;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = array[i];
        }
        SortPart.printArray(result);
    }

    public static void printAllCoprimePairs(int n) {
        if (n <= 2) {
            throw new IllegalArgumentException();
        }
        for (int i = n; i <= 2 * n; i++) {
            if (isPair(i, i + 2)) {
                System.out.println(i + " " + (i + 2));
            }
        }
    }

    private static boolean isPair(int a, int b) {
        return ArraysPart.isSimple(a) && ArraysPart.isSimple(b);
    }

    public static void armstrongNumbers(int k) {
        for (int i = 1; i <= k; i++) {
            if (isArmstrongNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isArmstrongNumber(int number) {
        int sum = 0;
        int count = 0;
        for (int i = number; i != 0; i /= 10) {
            sum += i % 10;
            count++;
        }
        return Math.pow(sum, count) == number;
    }

    public static void increaseFigures(int n) {
        if (n == 1) {
            throw new IllegalArgumentException();
        }
        int count = 1;
        for (int i = 1; i < n; i++) {
            count *= 10;
        }
        for (int i = count; i < count * 10; i++) {
            if (isIncrease(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isIncrease(int number) {
        int prev = number % 10;
        for (int i = number / 10; i != 0; i /= 10) {
            if (i % 10 >= prev) {
                return false;
            }
            prev = i % 10;
        }
        return true;
    }

    public static void sumOfNumbersWithOddFig(int n) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            count *= 10;
        }
        int sum = 0;
        for (int i = count; i < count * 10; i++) {
            if (isOnlyOdd(i)) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println("Сумма: " + sum + ", количество четных цифр в ней: " + countEvenFig(sum));
    }

    private static boolean isOnlyOdd(int number) {
        for (int i = number; i != 0; i /= 10) {
            if ((i % 10) % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    private static int countEvenFig(int number) {
        int count = 0;
        for (int i = number; i != 0; i /= 10) {
            if ((i % 10) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void sumOfFig(int number) {
        int count = 0;
        count = sumOfFig(number, count);
        System.out.println("Количество дейстивй: " + count);
    }

    private static int sumOfFig(int number, int count) {
        if (number == 0) {
            return count;
        }
        count++;
        int sum = 0;
        for (int i = number; i != 0; i /= 10) {
            sum += i % 10;
        }
        System.out.println(number - sum);
        return sumOfFig(number - sum, count);
    }
}
