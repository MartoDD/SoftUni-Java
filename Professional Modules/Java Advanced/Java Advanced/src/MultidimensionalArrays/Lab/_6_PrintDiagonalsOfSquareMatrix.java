package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _6_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int parameter = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(parameter, scanner);

        int row = 0;
        int col = 0;

        while (checkIfMatrixIsInBounds(row, col, parameter)) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }
        System.out.println();

        row = parameter - 1;
        col = 0;

        while (checkIfMatrixIsInBounds(row, col, parameter)) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }

    }

    private static boolean checkIfMatrixIsInBounds(int row, int col, int parameter) {
        return row >= 0 && row < parameter && col >= 0 && col < parameter;

    }

    private static int[][] readMatrix(int parameter, Scanner scanner) {

        int[][] matrix = new int[parameter][parameter];

        for (int row = 0; row < parameter; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
