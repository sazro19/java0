import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
        line();
        //changeColumns();
        line();
        sumOfColumn(new double[][]{{1, 2, 3}, {2, 2, 4}, {5, 2, 0}});
        line();
        positiveElOnDiagonal();
        line();
        randomMatrix();
        line();
        sortRows();
        line();
        sortColumns();
        line();
        createRandomOneZeroMatrix();
        line();
        changeOnMax();
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

    public static void changeColumns(){
        int[][] matrix = new int[][]{{1, 2, 3},{2, 3, 6},{7, 8, 9}};
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер первого столбца");
        int firstColumn = scanner.nextInt();
        System.out.println("Введите номер второго столбца");
        int secondColumn = scanner.nextInt();
        for (int i = 0; i < matrix.length; i++){
            int temp = matrix[i][firstColumn - 1];
            matrix[i][firstColumn - 1] = matrix[i][secondColumn - 1];
            matrix[i][secondColumn - 1] = temp;
        }
        System.out.println("Новая матрица: ");
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void sumOfColumn(double[][] matrix){
        for (double[] row : matrix){
            for (double el : row){
                if (el < 0){
                    throw new IllegalArgumentException();
                }
            }
        }
        double[] sums = new double[matrix[0].length];
        double max = sums[0];
        for (int i = 0; i < matrix[0].length; i++){
            for (int j = 0; j < matrix.length; j++){
                sums[i] += matrix[j][i];
            }
            if (max < sums[i]){
                max = sums[i];
            }
        }
        System.out.println("Суммы:");
        for (double el : sums){
            System.out.println(el);
        }
        System.out.println("Максимальная сумма: " + max);
    }

    public static void positiveElOnDiagonal(){
        double[][] matrix = new double[][]{{1, 2, 3, 4}, {2, -3, 4, 5}, {4, 5, 0, 1}, {6, 7, 8, 9}};
        for (int i = 0, j = 0; i < matrix.length; i++, j++){
            if (matrix[i][j] > 0){
                System.out.println("Положительный элемент: " + matrix[i][j]);
            }
        }
    }

    public static void randomMatrix(){
        int[][] matrix = new int[10][20];
        for (int i = 0; i < matrix.length; i++){
            int count = 0;
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = new Random().nextInt(16);
                if (matrix[i][j] == 5){
                    count++;
                }
                System.out.print(matrix[i][j] + " ");
            }
            if (count >= 3){
                System.out.print("(в этой строке (строка " + (i + 1) + ") число 5 встречается " + count + " раз(а))");
            }
            System.out.println("");
        }
    }

    public static void sortRows(){
        int[][] matrix = new int[][]{{4, 2, 5}, {2, 1, 6}, {3, 0, 7}};
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length - 1; j++){
                for (int k = matrix[i].length - 1; k > j; k--){
                    if(matrix[i][k - 1] > matrix[i][k]){
                        int temp = matrix[i][k - 1];
                        matrix[i][k - 1] = matrix[i][k];
                        matrix[i][k] = temp;
                    }
                }
            }
        }
        System.out.println("По возрастанию: ");
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length - 1; j++){
                for (int k = matrix[i].length - 1; k > j; k--){
                    if(matrix[i][k - 1] < matrix[i][k]){
                        int temp = matrix[i][k - 1];
                        matrix[i][k - 1] = matrix[i][k];
                        matrix[i][k] = temp;
                    }
                }
            }
        }
        System.out.println("По убыванию: ");
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void sortColumns(){
        int[][] matrix = new int[][]{{4, 2, 5}, {2, 1, 6}, {3, 0, 7}};
        for (int i = 0; i < matrix[0].length; i++){
            for (int j = 0; j < matrix.length - 1; j++){
                for (int k = matrix.length - 1; k > j; k--){
                    if(matrix[k - 1][i] > matrix[k][i]){
                        int temp = matrix[k - 1][i];
                        matrix[k - 1][i] = matrix[k][i];
                        matrix[k][i] = temp;
                    }
                }
            }
        }
        System.out.println("По возрастанию: ");
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < matrix[0].length; i++){
            for (int j = 0; j < matrix.length - 1; j++){
                for (int k = matrix.length - 1; k > j; k--){
                    if(matrix[k - 1][i] < matrix[k][i]){
                        int temp = matrix[k - 1][i];
                        matrix[k - 1][i] = matrix[k][i];
                        matrix[k][i] = temp;
                    }
                }
            }
        }
        System.out.println("По убыванию: ");
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void createRandomOneZeroMatrix(){
        int n = new Random().nextInt(5) + 1;
        int m = new Random().nextInt(n + 3) + n;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < n; i++){
            int count = i + 1;
            while (count != 0){
                int index = new Random().nextInt(m);
                while (matrix[index][i] == 1){
                    index = new Random().nextInt(m);
                }
                matrix[index][i] = 1;
                count--;
            }
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void changeOnMax(){
        int[][] matrix = new int[][]{{4, 8, 5}, {2, 1, 6}, {3, 0, 7}};
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (max < matrix[i][j]){
                    max = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] % 2 != 0){
                    matrix[i][j] = max;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void line(){
        System.out.println("----------------------------------------------");
    }

}
