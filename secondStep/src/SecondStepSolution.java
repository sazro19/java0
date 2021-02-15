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
        line();
        createMagicalSquare(6);
        line();
        insertArray(new int[]{1, 2, 3, 4, 9}, new int[]{7, 3, 4, 5}, 3);
        line();
        nonDecreasing(new int[]{3, 3, 5}, new int[]{1, 2, 6, 7});
        line();
        sortByChoice(new int[]{1, 2, 2, 3, 5, 6});
        line();
        sortByExchanges(new int[]{3, 2, 4, 6, 1, 9});
        line();
        sortByInserts(new int[]{12, 0, 3, 1, 5, 30, 10});
        line();
        shellSort(new double[]{3, 2, -5, 1, 4});
        line();
        placesToInsert(new double[]{1, 2, 3, 6, 8, 9}, new double[]{0, 4, 5, 7});
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
        printMatrix(matrix);
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
        printMatrix(matrix);
    }

    public static void changeColumns(){
        int[][] matrix = new int[][]{{1, 2, 3},{2, 3, 6},{7, 8, 9}};
        printMatrix(matrix);
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
        printMatrix(matrix);
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
        printMatrix(matrix);
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
        printMatrix(matrix);
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
        printMatrix(matrix);
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
        printMatrix(matrix);
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
        printMatrix(matrix);
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
        printMatrix(matrix);
    }

    public static void createMagicalSquare(int n){
        if (n <= 2){
            throw new IllegalArgumentException("Магический квадрат порядка 2x2 или 1x1 построить нельзя");
        }
        if (n % 2 != 0){
            magicalSquareOdd(n);
        }
        if (n % 4 == 0){
            magicalSquareDoubleEven(n);
        }
        if (n % 2 == 0 && n % 4 != 0){
            magicalSquareSingleEven(n);
        }
    }

    private static void magicalSquareOdd(int n){
        int[][] matrix = new int[n][n];
        int count = 1;
        int i = 0;
        int j = n / 2;
        matrix[i][j] = count;
        while (count < n*n){
            if (i == 0){
                i = n - 1;
            } else {
                i -= 1;
            }
            if (j == n - 1){
                j = 0;
            } else {
                j += 1;
            }
            if (matrix[i][j] != 0){
                for (int k = 0; k < 2; k++) {
                    if (i == n - 1) {
                        i = 0;
                    } else {
                        i += 1;
                    }
                }
                if (j == 0){
                    j = n - 1;
                } else {
                    j -= 1;
                }
            }
            count++;
            matrix[i][j] = count;
        }
        printMatrix(matrix);
    }

    private static void magicalSquareDoubleEven(int n){
        int[][] matrix = new int[n][n];
        int countUp = 0;
        int countDown = n * n + 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                countUp++;
                countDown--;
                if (((j < n / 4 || j >= n - n / 4) && (i < n / 4 || i >= n - n / 4)) ||
                        ((j >= n / 4 && j < n - n / 4) && (i >= n / 4 && i < n - n / 4))){
                    matrix[i][j] = countUp;
                } else {
                    matrix[i][j] = countDown;
                }
            }
        }
        printMatrix(matrix);
    }

    private static void magicalSquareSingleEven(int n){
        int[][] matrix = new int[n][n];
        magicalSquareOdd(n / 2, 0, 0, matrix);
        magicalSquareOdd(n / 2, n / 2, n / 2, matrix);
        magicalSquareOdd(n / 2, n / 2, 0, matrix);
        magicalSquareOdd(n / 2, 0, n / 2, matrix);
        int[][] helpMatrix = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i > (n - 1) / 2 && j > (n - 1) / 2) {
                    helpMatrix[i][j] = (n * n) / 4;
                }
                if (i < n / 2 && j > (n - 1) / 2){
                    helpMatrix[i][j] = (n * n) / 2;
                }
                if (i > (n - 1) / 2 && j < n / 2){
                    helpMatrix[i][j] = (3 * n * n) / 4;
                }
            }
        }
        for (int i = 0, k = n - 1; i < k; i++, k--){
            for (int j = 0; j < (n - 2) / 4; j++){
                if (i == n / 4){
                    continue;
                }
                helpMatrix[i][j] = helpMatrix[k][j];
                helpMatrix[k][j] = 0;
            }
        }
        for (int j = n / 4; j > 0; j--){
            helpMatrix[n / 4][j] = helpMatrix[n / 4 + n / 2][j];
            helpMatrix[n / 4 + n / 2][j] = 0;
        }
        for (int i = 0, k = n - 1; i < k; i++, k--){
            for (int j = n - 1; j > n - ((n - 2) / 4); j--){
                int temp = helpMatrix[i][j];
                helpMatrix[i][j] = helpMatrix[k][j];
                helpMatrix[k][j] = temp;
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] += helpMatrix[i][j];
            }
        }
        printMatrix(matrix);
    }

    private static void magicalSquareOdd(int n, int iShift, int jShift, int[][] matrix){
        int count = 1;
        int board = count + (n * n - 1);
        int i = iShift;
        int j = n / 2 + jShift;
        matrix[i][j] = count;
        while (count < board){
            if (i == iShift){
                i = n - 1 + iShift;
            } else {
                i -= 1;
            }
            if (j == n - 1 + jShift){
                j = jShift;
            } else {
                j += 1;
            }
            if (matrix[i][j] != 0){
                for (int k = 0; k < 2; k++) {
                    if (i == n - 1 + iShift) {
                        i = iShift;
                    } else {
                        i += 1;
                    }
                }
                if (j == jShift){
                    j = n - 1 + jShift;
                } else {
                    j -= 1;
                }
            }
            count++;
            matrix[i][j] = count;
        }
    }

    public static void insertArray(int[] firstArray, int[] secondArray, int k){
        if (firstArray.length <= 1 || k >= firstArray.length){
            throw new IllegalArgumentException();
        }
        int[] resultArray = new int[firstArray.length + secondArray.length];
        int resultIndex = 0;
        for (int i = 0; i < firstArray.length; i++){
            if (resultIndex == k + 1){
                for (int j = 0; j < secondArray.length; j++){
                    resultArray[resultIndex] = secondArray[j];
                    resultIndex++;
                }
                i--;
            } else {
                resultArray[resultIndex] = firstArray[i];
                resultIndex++;
            }
        }
        printArray(resultArray);
    }

    public static void nonDecreasing(int[] firstArray, int[] secondArray){
        for (int i = 1; i < firstArray.length; i++){
            if (firstArray[i - 1] > firstArray[i]){
                throw new IllegalArgumentException();
            }
        }
        for (int i = 1; i < secondArray.length; i++){
            if (secondArray[i - 1] > secondArray[i]){
                throw new IllegalArgumentException();
            }
        }
        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int[] resultArray = new int[firstArray.length + secondArray.length];
        for (int i = 0; i < resultArray.length; i++){
            if (firstArray[firstArrayIndex] <= secondArray[secondArrayIndex]) {
                resultArray[i] = firstArray[firstArrayIndex];
                firstArrayIndex++;
                if (firstArrayIndex == firstArray.length){
                    firstArrayIndex--;
                    firstArray[firstArrayIndex] = Integer.MAX_VALUE;
                }
            } else {
                resultArray[i] = secondArray[secondArrayIndex];
                secondArrayIndex++;
                if (secondArrayIndex == secondArray.length){
                    secondArrayIndex--;
                    secondArray[secondArrayIndex] = Integer.MAX_VALUE;
                }
            }
        }
        printArray(resultArray);
    }

    public static void sortByChoice(int[] array){
        for (int i = 0; i < array.length; i++){
            int max = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] > array[max]){
                    max = j;
                }
            }
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
        }
        printArray(array);
    }

    public static void sortByExchanges(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        printArray(array);
    }

    public static void sortByInserts(int[] array){
        for (int i = 1; i < array.length; i++){
            if (array[i] < array[i - 1]){
                int index = binarySearch(array, array[i], 0, i - 1);
                int temp = array[i];
                for (int j = i; j >= index; j--){
                    if (j == 0){
                        break;
                    }
                    array[j] = array[j - 1];
                }
                array[index] = temp;
            }
        }
        printArray(array);
    }

    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
                if (sortedArray[low] > key){
                    index = low;
                    break;
                }
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
                if (high == -1){
                    index = 0;
                    break;
                }
                if (sortedArray[high] < key){
                    index = high + 1;
                    break;
                }
            } else if (sortedArray[mid] == key) {
                index = mid + 1;
                break;
            }
        }
        return index;
    }

    public static void shellSort(double[] array){
        int i = 0;
        while (i < array.length - 1){
            if (array[i] <= array[i + 1]){
                i++;
            } else {
                double temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                if (i != 0){
                    i--;
                }
            }
        }
        printArray(array);
    }

    public static void placesToInsert(double[] firstArray, double[] secondArray) {
        int k = 0;
        for (int i = 0; i < secondArray.length; i++) {
            for (int j = k; j <= firstArray.length; j++) {
                if (j == firstArray.length){
                    System.out.println(i + " элемент из второй последовательности на место " + (j - 1) + " из первой");
                    break;
                }
                if (firstArray[j] >= secondArray[i]) {
                    System.out.println(i + " элемент из второй последовательности на место " + j + " из первой");
                    k = j + 1;
                    break;
                }
                if ((i == secondArray.length - 1) && (j == firstArray.length - 1) && (firstArray[j] <= secondArray[i])) {
                    System.out.println(i + " элемент из второй последовательности на место " + j + " из первой");
                    break;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void printArray(int[] array){
        for (int el : array){
            System.out.print(el + " ");
        }
        System.out.println("");
    }

    public static void printArray(double[] array){
        for (double el : array){
            System.out.print(el + " ");
        }
        System.out.println("");
    }

    public static void printMatrix(double[][] matrix){
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
