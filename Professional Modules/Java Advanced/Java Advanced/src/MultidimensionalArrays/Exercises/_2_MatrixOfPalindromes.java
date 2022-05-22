package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _2_MatrixOfPalindromes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] parameters = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = parameters[0];
        int cols = parameters[1];

        String[][] matrix = new String[rows][cols];
        //a=97
        char initial = 97;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String toAdd = Character.toString(initial + row) + Character.toString(initial + row + col) + Character.toString(initial + row);
                matrix[row][col] = toAdd;
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();

        }
    }
}
