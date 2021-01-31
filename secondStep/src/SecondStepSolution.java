import java.util.Arrays;
import java.util.Random;

public class SecondStepSolution {

    public static void main(String[] args){
        System.out.println(sum(10, 3));
        System.out.println(changes(new double[]{0.1, 2, 3, 4.5}, 2));
        countEl(new double[]{1, 2, 3, -2, -3.5, 0, 0, -3});
        changeMaxMin(new double[]{-1, 0, 3, 10, -20.5, 2, 1.3, 100});
        print(new int[]{1, 2, 22, 33, 4});
    }

    public static int sum(int n, int k){
        if (n <= 0){
            throw new IllegalArgumentException("n должно быть больше нуля");
        }
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++){
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

    public static int changes(double[] array, double z){
        if (array.length == 0){
            throw new IllegalArgumentException("Массив должен содержать хотябы один элемент");
        }
        int changes = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > z){
                array[i] = z;
                changes++;
            }
        }
        System.out.println("Новый массив: " + Arrays.toString(array));
        return changes;
    }

    public static void countEl(double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("Массив должен содержать хотябы один элемент");
        }
        int positive = 0;
        int negative = 0;
        for (double i : array){
            if (i > 0){
                positive++;
            }
            if (i < 0){
                negative++;
            }
        }
        System.out.println("Количество положительных элементов: " + positive);
        System.out.println("Количество отрицательных элементов: " + negative);
        System.out.println("Количество нулей: " + (array.length - (positive + negative)));
    }

    public static void changeMaxMin(double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("Массив должен содержать хотябы один элемент");
        }
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < array.length; ++i){
            if (array[i] > array[maxIndex]){
                maxIndex = i;
            }
            if (array[i] < array[minIndex]){
                minIndex = i;
            }
        }
        double temp = array[maxIndex];
        array[maxIndex] = array[minIndex];
        array[minIndex] = temp;
        System.out.println(Arrays.toString(array));
    }

    public static void print(int[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("Массив должен содержать хотябы один элемент");
        }
        for (int i = 0; i < array.length; i++){
            if (array[i] > i + 1){
                System.out.println(array[i]);
            }
        }
    }

}
