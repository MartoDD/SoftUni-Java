package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _3_DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int sumFirstDiagonal = 0;
        int row = 0;
        int col = 0;
        while (checkIfMatrixIsInBounds(row, col, matrix)) {
            sumFirstDiagonal += matrix[row][col];
            row++;
            col++;
        }

        int sumSecondDiagonal = 0;
        row = matrix.length - 1;
        col = 0;
        while (checkIfMatrixIsInBounds(row, col, matrix)) {
            sumSecondDiagonal += matrix[row][col];
            row--;
            col++;
        }

        System.out.println(Math.abs(sumFirstDiagonal - sumSecondDiagonal));


    }

    private static boolean checkIfMatrixIsInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;

    }

    private static int[][] readMatrix(Scanner scanner) {

        int parameter = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[parameter][parameter];

        for (int row = 0; row < parameter; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}

