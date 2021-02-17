import java.util.Arrays;

public class ArraysPart {

    public static int sum(int n, int k) {
        if (n <= 0) {
            throw new IllegalArgumentException("n должно быть больше нуля");
        }
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        int sum = 0;
        for (int i : array) {
            if (i % k == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int changes(double[] array, double z) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив должен содержать хотябы один элемент");
        }
        int changes = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > z) {
                array[i] = z;
                changes++;
            }
        }
        System.out.println("Новый массив: " + Arrays.toString(array));
        return changes;
    }

    public static void countEl(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив должен содержать хотябы один элемент");
        }
        int positive = 0;
        int negative = 0;
        for (double i : array) {
            if (i > 0) {
                positive++;
            }
            if (i < 0) {
                negative++;
            }
        }
        System.out.println("Количество положительных элементов: " + positive);
        System.out.println("Количество отрицательных элементов: " + negative);
        System.out.println("Количество нулей: " + (array.length - (positive + negative)));
    }

    public static void changeMaxMin(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив должен содержать хотябы один элемент");
        }
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        double temp = array[maxIndex];
        array[maxIndex] = array[minIndex];
        array[minIndex] = temp;
        System.out.println(Arrays.toString(array));
    }

    public static void print(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив должен содержать хотябы один элемент");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > i + 1) {
                System.out.println(array[i]);
            }
        }
    }

    public static void sumOfElWithSimpleNumber(double[] sequence) {
        double sum = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (isSimple(i + 1)) { // индекс элемента i, а его порядковый номер i + 1
                sum += sequence[i];
            }
        }
        System.out.println(sum);
    }

    private static boolean isSimple(double number) {
        if (number == 1) {
            return false;
        }
        double temp;
        for (int i = 2; i <= number / 2; i++) {
            temp = number % i;
            if (temp == 0) {
                return false;
            }
        }
        return true;
    }

    public static double max(double[] array) {
        if (array.length % 2 != 0) {
            throw new IllegalArgumentException("Количество элементов должно быть 2n, т. е. четным");
        }
        double max = array[0];
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            if (max < array[i] + array[j]) {
                max = array[i] + array[j];
            }
        }
        return max;
    }

    public static int[] removeMinEl(int[] array) {
        if (array.length <= 1) {
            throw new IllegalArgumentException("Количество элементов должно быть больше 1");
        }
        int numberOfMin = 0;
        int min = array[0];
        for (int i : array) {
            if (i < min) {
                min = i;
            }
        }
        for (int i : array) {
            if (i == min) {
                numberOfMin++;
            }
        }
        int[] newArray = new int[array.length - numberOfMin];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] != min) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }

    public static void mostRepeating(int[] array) {
        int[][] temp = new int[array.length][2];
        for (int i = 0; i < array.length; i++) {
            temp[i][0] = array[i];
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    temp[i][1]++;
                }
            }
        }
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (temp[i][1] > temp[maxIndex][1]) {
                maxIndex = i;
            }
        }
        int[] allMax = new int[array.length];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (temp[i][1] == temp[maxIndex][1]) {
                allMax[j++] = temp[i][0];
            } else {
                allMax[j++] = Integer.MAX_VALUE;
            }
        }
        int min = allMax[0];
        for (int i : allMax) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println(min);
    }

    public static void compress(int[] array) {
        if (array.length <= 1) {
            throw new IllegalArgumentException("Количество элементов должно быть больше 1");
        }
        for (int i = 1; i < array.length; i += 2) {
            array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
    }
}
