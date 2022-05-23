package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class _1_FillTheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int value = Integer.parseInt(input[0]);
        int[][] matrix = new int[value][value];
        if (value == 0) {
            System.out.println(0);
        } else {
            switch (input[1]) {
                case "A":
                    matrix = printMatrixA(value);
                    break;
                case "B":
                    matrix = printMatrixB(value);
                    break;
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();

        }

    }

    private static int[][] printMatrixB(int value) {

        int[][] matrix = new int[value][value];
        int number = 1;
        for (int col = 0; col < value; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < value; row++) {
                    matrix[row][col] = number;
                    number++;
                }
            } else {
                for (int row = value - 1; row >= 0; row--) {
                    matrix[row][col] = number;
                    number++;
                }
            }
        }
        return matrix;

    }

    private static int[][] printMatrixA(int value) {

        int[][] matrix = new int[value][value];
        int number = 1;
        for (int col = 0; col < value; col++) {
            for (int row = 0; row < value; row++) {
                matrix[row][col] = number;
                number++;
            }
        }
        return matrix;
    }
}
