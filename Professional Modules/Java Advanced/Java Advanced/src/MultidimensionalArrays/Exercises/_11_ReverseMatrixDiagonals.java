package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _11_ReverseMatrixDiagonals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] parameters = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = parameters[0];
        int cols = parameters[1];

        int[][] matrix = readMatrix(rows, cols, scanner);

        for (int i = cols - 1; i >= 0; i--) {
            int row = rows - 1;
            int col = i;
            while (row >= 0 && col < cols) {
                System.out.print(matrix[row][col] + " ");
                row--;
                col++;
            }
            System.out.println();
        }
        for (int i = 0; i < rows - 1; i++) {

            int row = rows - 2 - i;
            int col = 0;

            while (row >= 0 && col < cols) {
                System.out.print(matrix[row][col] + " ");
                row--;
                col++;
            }
            System.out.println();
        }

    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
