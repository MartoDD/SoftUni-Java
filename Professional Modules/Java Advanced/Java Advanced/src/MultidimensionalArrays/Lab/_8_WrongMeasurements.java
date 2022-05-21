package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _8_WrongMeasurements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(rows, scanner);

        int[] indexOfWrongNumber = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rowOfWrongNumber = indexOfWrongNumber[0];
        int colOfWrongNumber = indexOfWrongNumber[1];

        int wrongNumber = matrix[rowOfWrongNumber][colOfWrongNumber];

        int[][] outputMatrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            outputMatrix[row] = new int[matrix[row].length];
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongNumber) {
                    int sum = calculateSumWrongNumber(matrix, row, col,wrongNumber);
                    outputMatrix[row][col] = sum;
                } else {
                    outputMatrix[row][col] = matrix[row][col];
                }

            }
        }
        for (int[] row : outputMatrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static int calculateSumWrongNumber(int[][] matrix, int row, int col, int wrongNumber) {

        int sum = 0;
        if (col != 0 && matrix[row][col - 1] != wrongNumber) {
            sum += matrix[row][col - 1];
        }
        if (col < matrix[row].length - 1 && matrix[row][col + 1] != wrongNumber) {
            sum += matrix[row][col + 1];
        }
        if (row > 0 && matrix[row - 1][col] != wrongNumber) {
            sum += matrix[row - 1][col];
        }
        if (row < matrix.length - 1 && matrix[row + 1][col] != wrongNumber) {
            sum += matrix[row + 1][col];
        }

        return sum;
    }

    private static int[][] readMatrix(int rows, Scanner scanner) {

        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
