import java.util.Arrays;
import java.util.Random;

public class SecondStepSolution {

    public static void main(String[] args){
        System.out.println(sum(10, 3));
        line();
        System.out.println(changes(new double[]{0.1, 2, 3, 4.5}, 2));
        line();
        countEl(new double[]{1, 2, 3, -2, -3.5, 0, 0, -3});
        line();
        changeMaxMin(new double[]{-1, 0, 3, 10, -20.5, 2, 1.3, 100});
        line();
        print(new int[]{1, 2, 22, 33, 4});
        line();
        System.out.println(max(new double[]{11, -3, 8, 4, 6, 12}));
        line();
        System.out.println(Arrays.toString(removeMinEl(new int[]{1, 1, 2, 3, 1})));
        line();
        mostRepeating(new int[]{0, 1, 2, 2, 1, 3, 3, 3, 4, 4, 4, 4});
        line();
        compress(new int[]{1, 2, 3, 4, 5});
        line();
        oddColumns(new double[][]{{3, 2, 10},{5, 6, 3},{1, 4, 9}});
        line();
        diagonal(new double[][]{{3, 2, 10},{5, 6, 3},{1, 4, 9}});
        line();
        printKP(new double[][]{{3, 2, 10},{5, 6, 3},{1, 4, 9}}, 2, 3);
        line();
        createSquareMatrix(6);
        line();
        createAnotherSquareMatrix(8);
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

    public static double max(double[] array){
        if (array.length % 2 != 0){
            throw new IllegalArgumentException("Количество элементов должно быть 2n, т. е. четным");
        }
        double max = array[0];
        for (int i = 0, j = array.length - 1; i < j; i++, j--){
            if (max < array[i] + array[j]){
                max = array[i] + array[j];
            }
        }
        return max;
    }

    public static int[] removeMinEl(int[] array){
        if (array.length <= 1){
            throw new IllegalArgumentException("Количество элементов должно быть больше 1");
        }
        int numberOfMin = 0;
        int min = array[0];
        for (int i : array){
            if (i < min){
                min = i;
            }
        }
        for (int i : array){
            if (i == min){
                numberOfMin++;
            }
        }
        int[] newArray = new int[array.length - numberOfMin];
        for (int i = 0, j = 0; i < array.length; i++){
            if (array[i] != min){
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }

    public static void mostRepeating(int[] array) {
        int[][] temp = new int[array.length][2];
        for (int i = 0; i < array.length; i++) {
            temp[i][0] = array[i];
            for (int j = 0; j < array.length; j++){
                if (array[i] == array[j]) {
                    temp[i][1]++;
                }
            }
        }
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++){
            if (temp[i][1] > temp[maxIndex][1]){
                maxIndex = i;
            }
        }
        int[] allMax = new int[array.length];
        for (int i = 0, j = 0; i < array.length; i++){
            if (temp[i][1] == temp[maxIndex][1]){
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

    public static void compress(int[] array){
        if (array.length <= 1){
            throw new IllegalArgumentException("Количество элементов должно быть больше 1");
        }
        for (int i = 1; i < array.length; i += 2){
            array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void oddColumns(double[][] matrix){
        int lineSize = matrix[0].length;
        for (double[] line : matrix){
            if (lineSize != line.length){
                throw new IllegalArgumentException("Некорректная матрица");
            }
        }
        for (int j = 0; j < matrix[0].length; j += 2){
                if (matrix[0][j] > matrix[matrix.length - 1][j]){
                    System.out.println("Колонка: ");
                    for (int i = 0; i < matrix.length; i++){
                        System.out.println(matrix[i][j]);
                    }
                }
        }
    }

    public static void diagonal(double[][] squareMatrix){
        for (double[] line : squareMatrix){
            if (squareMatrix.length != line.length){
                throw new IllegalArgumentException("Матрица должна быть квадратной");
            }
        }
        for (int i = 0, j = 0; i < squareMatrix.length; i++, j++){
            if (i == j){
                System.out.println(squareMatrix[i][j]);
            }
        }
    }

    public static void printKP(double[][] matrix, int k, int p) {
        int lineSize = matrix[0].length;
        for (double[] line : matrix) {
            if (lineSize != line.length) {
                throw new IllegalArgumentException("Некорректная матрица");
            }
        }
        for (int i = 0; i < matrix[k].length; i++) {
            System.out.print(matrix[k - 1][i] + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][p - 1] + " ");
        }
    }

    public static void createSquareMatrix(int n){
        if (n % 2 != 0){
            throw new IllegalArgumentException("n должно быть четным и больше 3");
        }
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i % 2 == 0){
                    matrix[i][j] = j + 1;
                } else {
                    matrix[i][j] = n - j;
                }
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void createAnotherSquareMatrix(int n){
        if (n % 2 != 0){
            throw new IllegalArgumentException("n должно быть четным и больше 5");
        }
        int zeros = 0;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++){
            zeros = 0;
            for (int j = 0; j < n; j++){
                if (j == n - i){
                    zeros = i + 1;
                }
                matrix[i][j] = i + 1 - zeros;
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void line(){
        System.out.println("----------------------------------------------");
    }

}
