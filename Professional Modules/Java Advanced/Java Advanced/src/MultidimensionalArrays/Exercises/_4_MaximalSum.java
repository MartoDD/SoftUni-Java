package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _4_MaximalSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int biggestSum = Integer.MIN_VALUE;
        int[][] matrixForOutput = new int[3][3];

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = getCurrentSum(matrix, row, col);
                if (currentSum > biggestSum) {
                    biggestSum = currentSum;
                    matrixForOutput = saveCurrentMatrix(matrix, row, col);
                }
            }
        }
        System.out.println("Sum = " + biggestSum);
        printMatrix(matrixForOutput);


    }

    private static void printMatrix(int[][] matrixForOutput) {
        for (int[] row : matrixForOutput) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();

        }
    }

    private static int[][] saveCurrentMatrix(int[][] matrix, int row, int col) {
        int[][] matrixForOutput;
        matrixForOutput = new int[][]{{matrix[row][col], matrix[row][col + 1], matrix[row][col + 2]},
                {matrix[row + 1][col], matrix[row + 1][col + 1], matrix[row + 1][col + 2]},
                {matrix[row + 2][col], matrix[row + 2][col + 1], matrix[row + 2][col + 2]}
        };
        return matrixForOutput;
    }

    private static int getCurrentSum(int[][] matrix, int row, int col) {
        return matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] parameters = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = parameters[0];
        int cols = parameters[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
