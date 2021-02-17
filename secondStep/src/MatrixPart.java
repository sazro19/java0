import java.util.Random;
import java.util.Scanner;

public class MatrixPart {

    public static void oddColumns(double[][] matrix) {
        int lineSize = matrix[0].length;
        for (double[] line : matrix) {
            if (lineSize != line.length) {
                throw new IllegalArgumentException("Некорректная матрица");
            }
        }
        for (int j = 0; j < matrix[0].length; j += 2) {
            if (matrix[0][j] > matrix[matrix.length - 1][j]) {
                System.out.println("Колонка: ");
                for (int i = 0; i < matrix.length; i++) {
                    System.out.println(matrix[i][j]);
                }
            }
        }
    }

    public static void diagonal(double[][] squareMatrix) {
        for (double[] line : squareMatrix) {
            if (squareMatrix.length != line.length) {
                throw new IllegalArgumentException("Матрица должна быть квадратной");
            }
        }
        for (int i = 0, j = 0; i < squareMatrix.length; i++, j++) {
            if (i == j) {
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

    public static void createSquareMatrix(int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n должно быть четным и больше 3");
        }
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    matrix[i][j] = j + 1;
                } else {
                    matrix[i][j] = n - j;
                }
            }
        }
        printMatrix(matrix);
    }

    public static void createAnotherSquareMatrix(int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n должно быть четным и больше 5");
        }
        int zeros = 0;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            zeros = 0;
            for (int j = 0; j < n; j++) {
                if (j == n - i) {
                    zeros = i + 1;
                }
                matrix[i][j] = i + 1 - zeros;
            }
        }
        printMatrix(matrix);
    }

    public static void changeColumns() {
        int[][] matrix = new int[][]{{1, 2, 3}, {2, 3, 6}, {7, 8, 9}};
        printMatrix(matrix);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер первого столбца");
        int firstColumn = scanner.nextInt();
        System.out.println("Введите номер второго столбца");
        int secondColumn = scanner.nextInt();
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][firstColumn - 1];
            matrix[i][firstColumn - 1] = matrix[i][secondColumn - 1];
            matrix[i][secondColumn - 1] = temp;
        }
        System.out.println("Новая матрица: ");
        printMatrix(matrix);
    }

    public static void sumOfColumn(double[][] matrix) {
        for (double[] row : matrix) {
            for (double el : row) {
                if (el < 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
        double[] sums = new double[matrix[0].length];
        double max = sums[0];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sums[i] += matrix[j][i];
            }
            if (max < sums[i]) {
                max = sums[i];
            }
        }
        System.out.println("Суммы:");
        for (double el : sums) {
            System.out.println(el);
        }
        System.out.println("Максимальная сумма: " + max);
    }

    public static void positiveElOnDiagonal() {
        double[][] matrix = new double[][]{{1, 2, 3, 4}, {2, -3, 4, 5}, {4, 5, 0, 1}, {6, 7, 8, 9}};
        for (int i = 0, j = 0; i < matrix.length; i++, j++) {
            if (matrix[i][j] > 0) {
                System.out.println("Положительный элемент: " + matrix[i][j]);
            }
        }
    }

    public static void randomMatrix() {
        int[][] matrix = new int[10][20];
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Random().nextInt(16);
                if (matrix[i][j] == 5) {
                    count++;
                }
                System.out.print(matrix[i][j] + " ");
            }
            if (count >= 3) {
                System.out.print("(в этой строке (строка " + (i + 1) + ") число 5 встречается " + count + " раз(а))");
            }
            System.out.println("");
        }
    }

    public static void sortRows() {
        int[][] matrix = new int[][]{{4, 2, 5}, {2, 1, 6}, {3, 0, 7}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                for (int k = matrix[i].length - 1; k > j; k--) {
                    if (matrix[i][k - 1] > matrix[i][k]) {
                        int temp = matrix[i][k - 1];
                        matrix[i][k - 1] = matrix[i][k];
                        matrix[i][k] = temp;
                    }
                }
            }
        }
        System.out.println("По возрастанию: ");
        printMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                for (int k = matrix[i].length - 1; k > j; k--) {
                    if (matrix[i][k - 1] < matrix[i][k]) {
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

    public static void sortColumns() {
        int[][] matrix = new int[][]{{4, 2, 5}, {2, 1, 6}, {3, 0, 7}};
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                for (int k = matrix.length - 1; k > j; k--) {
                    if (matrix[k - 1][i] > matrix[k][i]) {
                        int temp = matrix[k - 1][i];
                        matrix[k - 1][i] = matrix[k][i];
                        matrix[k][i] = temp;
                    }
                }
            }
        }
        System.out.println("По возрастанию: ");
        printMatrix(matrix);
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                for (int k = matrix.length - 1; k > j; k--) {
                    if (matrix[k - 1][i] < matrix[k][i]) {
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

    public static void createRandomOneZeroMatrix() {
        int n = new Random().nextInt(5) + 1;
        int m = new Random().nextInt(n + 3) + n;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < n; i++) {
            int count = i + 1;
            while (count != 0) {
                int index = new Random().nextInt(m);
                while (matrix[index][i] == 1) {
                    index = new Random().nextInt(m);
                }
                matrix[index][i] = 1;
                count--;
            }
        }
        printMatrix(matrix);
    }

    public static void changeOnMax() {
        int[][] matrix = new int[][]{{4, 8, 5}, {2, 1, 6}, {3, 0, 7}};
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 != 0) {
                    matrix[i][j] = max;
                }
            }
        }
        printMatrix(matrix);
    }

    public static void createMagicalSquare(int n) {
        if (n <= 2) {
            throw new IllegalArgumentException("Магический квадрат порядка 2x2 или 1x1 построить нельзя");
        }
        if (n % 2 != 0) {
            magicalSquareOdd(n);
        }
        if (n % 4 == 0) {
            magicalSquareDoubleEven(n);
        }
        if (n % 2 == 0 && n % 4 != 0) {
            magicalSquareSingleEven(n);
        }
    }

    private static void magicalSquareOdd(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int i = 0;
        int j = n / 2;
        matrix[i][j] = count;
        while (count < n * n) {
            if (i == 0) {
                i = n - 1;
            } else {
                i -= 1;
            }
            if (j == n - 1) {
                j = 0;
            } else {
                j += 1;
            }
            if (matrix[i][j] != 0) {
                for (int k = 0; k < 2; k++) {
                    if (i == n - 1) {
                        i = 0;
                    } else {
                        i += 1;
                    }
                }
                if (j == 0) {
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

    private static void magicalSquareDoubleEven(int n) {
        int[][] matrix = new int[n][n];
        int countUp = 0;
        int countDown = n * n + 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                countUp++;
                countDown--;
                if (((j < n / 4 || j >= n - n / 4) && (i < n / 4 || i >= n - n / 4)) ||
                        ((j >= n / 4 && j < n - n / 4) && (i >= n / 4 && i < n - n / 4))) {
                    matrix[i][j] = countUp;
                } else {
                    matrix[i][j] = countDown;
                }
            }
        }
        printMatrix(matrix);
    }

    private static void magicalSquareSingleEven(int n) {
        int[][] matrix = new int[n][n];
        magicalSquareOdd(n / 2, 0, 0, matrix);
        magicalSquareOdd(n / 2, n / 2, n / 2, matrix);
        magicalSquareOdd(n / 2, n / 2, 0, matrix);
        magicalSquareOdd(n / 2, 0, n / 2, matrix);
        int[][] helpMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > (n - 1) / 2 && j > (n - 1) / 2) {
                    helpMatrix[i][j] = (n * n) / 4;
                }
                if (i < n / 2 && j > (n - 1) / 2) {
                    helpMatrix[i][j] = (n * n) / 2;
                }
                if (i > (n - 1) / 2 && j < n / 2) {
                    helpMatrix[i][j] = (3 * n * n) / 4;
                }
            }
        }
        for (int i = 0, k = n - 1; i < k; i++, k--) {
            for (int j = 0; j < (n - 2) / 4; j++) {
                if (i == n / 4) {
                    continue;
                }
                helpMatrix[i][j] = helpMatrix[k][j];
                helpMatrix[k][j] = 0;
            }
        }
        for (int j = n / 4; j > 0; j--) {
            helpMatrix[n / 4][j] = helpMatrix[n / 4 + n / 2][j];
            helpMatrix[n / 4 + n / 2][j] = 0;
        }
        for (int i = 0, k = n - 1; i < k; i++, k--) {
            for (int j = n - 1; j > n - ((n - 2) / 4); j--) {
                int temp = helpMatrix[i][j];
                helpMatrix[i][j] = helpMatrix[k][j];
                helpMatrix[k][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] += helpMatrix[i][j];
            }
        }
        printMatrix(matrix);
    }

    private static void magicalSquareOdd(int n, int iShift, int jShift, int[][] matrix) {
        int count = 1;
        int board = count + (n * n - 1);
        int i = iShift;
        int j = n / 2 + jShift;
        matrix[i][j] = count;
        while (count < board) {
            if (i == iShift) {
                i = n - 1 + iShift;
            } else {
                i -= 1;
            }
            if (j == n - 1 + jShift) {
                j = jShift;
            } else {
                j += 1;
            }
            if (matrix[i][j] != 0) {
                for (int k = 0; k < 2; k++) {
                    if (i == n - 1 + iShift) {
                        i = iShift;
                    } else {
                        i += 1;
                    }
                }
                if (j == jShift) {
                    j = n - 1 + jShift;
                } else {
                    j -= 1;
                }
            }
            count++;
            matrix[i][j] = count;
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
