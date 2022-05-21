package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _4_SumMatrixElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] parameters = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = parameters[0];
        int cols = parameters[1];

        int[][] matrix = readMatrix(rows, cols, scanner);

        int sumOfMatrixElements = sumOfMatrixElements(matrix);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sumOfMatrixElements);

    }

    private static int sumOfMatrixElements(int[][] matrix) {
        int sum = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
