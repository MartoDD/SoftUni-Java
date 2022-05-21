package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _5_MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] parameters = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = parameters[0];
        int cols = parameters[1];

        int[][] matrix = readMatrix(rows, cols, scanner);
        int biggestSum = Integer.MIN_VALUE;
        int[][] smallMatrix = new int[2][2];
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int sum = matrix[row][col]
                        + matrix[row][col + 1]
                        + matrix[row + 1][col]
                        + matrix[row + 1][col + 1];
                if (sum > biggestSum) {
                    biggestSum = sum;
                    smallMatrix = new int[][]{
                            {matrix[row][col], matrix[row][col + 1]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1]}
                    };
                }
            }
        }
        for (int[] row : smallMatrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();

        }
        System.out.println(biggestSum);
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
