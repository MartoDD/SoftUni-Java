package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class _1_FillTheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int value = Integer.parseInt(input[0]);
        if (value == 0) {
            System.out.println(0);
        } else {
            switch (input[1]) {
                case "A":
                    printMatrixA(value);
                    break;
                case "B":
                    printMatrixB(value);
                    break;
            }
        }
    }

    private static void printMatrixB(int value) {

        int[][] matrix = new int[value][value];
        for (int row = 0; row < value; row++) {
            int number = row + 1;
            int toAdd = value * 2;
            for (int col = 0; col < value; col++) {
                if (col % 2 == 0) {
                    if (col == 0) {
                        matrix[row][col] = number;
                    } else {
                        matrix[row][col] = matrix[row][col - 2] + toAdd;
                    }
                } else {
                    if (col == 1) {
                        matrix[row][col] = matrix[row][col - 1] + toAdd - number - row;
                    } else {
                        matrix[row][col] = matrix[row][col - 2] + toAdd;
                    }
                }
            }
        }
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();

        }

    }

    private static void printMatrixA(int value) {

        int[][] matrix = new int[value][value];
        for (int row = 0; row < value; row++) {
            int number = row + 1;
            for (int col = 0; col < value; col++) {
                matrix[row][col] = number;
                number += value;
            }

        }
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();

        }

    }
}
