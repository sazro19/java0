import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SecondStepSolution {

    public static void main(String[] args){
        System.out.println(ArraysPart.sum(10, 3));
        line();
        System.out.println(ArraysPart.changes(new double[]{0.1, 2, 3, 4.5}, 2));
        line();
        ArraysPart.countEl(new double[]{1, 2, 3, -2, -3.5, 0, 0, -3});
        line();
        ArraysPart.changeMaxMin(new double[]{-1, 0, 3, 10, -20.5, 2, 1.3, 100});
        line();
        ArraysPart.print(new int[]{1, 2, 22, 33, 4});
        line();
        ArraysPart.sumOfElWithSimpleNumber(new double[]{1, 2, 3, 4, 5, 6});
        line();
        System.out.println(ArraysPart.max(new double[]{11, -3, 8, 4, 6, 12}));
        line();
        int[] array = ArraysPart.removeMinEl(new int[]{1, 1, 2, 3, 1});
        SortPart.printArray(array = ArraysPart.removeMinEl(new int[]{1, 1, 2, 3, 1}));
        line();
        ArraysPart.mostRepeating(new int[]{0, 1, 2, 2, 1, 3, 3, 3, 4, 4, 4, 4});
        line();
        ArraysPart.compress(new int[]{1, 2, 3, 4, 5});
        line();
        MatrixPart.oddColumns(new double[][]{{3, 2, 10},{5, 6, 3},{1, 4, 9}});
        line();
        MatrixPart.diagonal(new double[][]{{3, 2, 10},{5, 6, 3},{1, 4, 9}});
        line();
        MatrixPart.printKP(new double[][]{{3, 2, 10},{5, 6, 3},{1, 4, 9}}, 2, 3);
        line();
        MatrixPart.createSquareMatrix(6);
        line();
        MatrixPart.createAnotherSquareMatrix(8);
        line();
        //MatrixPart.changeColumns();
        line();
        MatrixPart.sumOfColumn(new double[][]{{1, 2, 3}, {2, 2, 4}, {5, 2, 0}});
        line();
        MatrixPart.positiveElOnDiagonal();
        line();
        MatrixPart.randomMatrix();
        line();
        MatrixPart.sortRows();
        line();
        MatrixPart.sortColumns();
        line();
        MatrixPart.createRandomOneZeroMatrix();
        line();
        MatrixPart.changeOnMax();
        line();
        MatrixPart.createMagicalSquare(6);
        line();
        SortPart.insertArray(new int[]{1, 2, 3, 4, 9}, new int[]{7, 3, 4, 5}, 3);
        line();
        SortPart.nonDecreasing(new int[]{3, 3, 5}, new int[]{1, 2, 6, 7});
        line();
        SortPart.sortByChoice(new int[]{1, 2, 2, 3, 5, 6});
        line();
        SortPart.sortByExchanges(new int[]{3, 2, 4, 6, 1, 9});
        line();
        SortPart.sortByInserts(new int[]{12, 0, 3, 1, 5, 30, 10});
        line();
        SortPart.shellSort(new double[]{3, 2, -5, 1, 4});
        line();
        SortPart.placesToInsert(new double[]{1, 2, 3, 6, 8, 9}, new double[]{0, 4, 5, 7});
        line();
        SortPart.commonDenominator(new int[]{1, 1, 3, 5}, new int[]{3, 4, 5, 6});
    }

    public static void line(){
        System.out.println("----------------------------------------------");
    }
}
