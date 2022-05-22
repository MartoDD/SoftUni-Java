package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _5_MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] parameters = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = parameters[0];
        int cols = parameters[1];


        String[][] matrix = readMatrix(scanner, rows, cols);

        String[] command = scanner.nextLine().split("\\s+");

        String[][] forOutput = new String[rows][cols];

        while (!command[0].equals("END")) {

            if (!command[0].equals("swap") || command.length > 5) {
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);

                if (isInBounds(rows, cols, row1, col1, row2, col2)) {
                    String first = matrix[row1][col1];
                    String second = matrix[row2][col2];

                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            if (row == row1 && col == col1) {
                                forOutput[row1][col1] = second;
                            } else if (row == row2 && col == col2) {
                                forOutput[row2][col2] = first;
                            } else {
                                forOutput[row][col] = matrix[row][col];
                            }
                        }
                    }
                    matrix = forOutput;
                    printMatrix(forOutput);


                } else {
                    System.out.println("Invalid input!");
                }
            }
            command = scanner.nextLine().split("\\s+");
        }


    }

    private static boolean isInBounds(int rows, int cols, int row1, int col1, int row2, int col2) {
        return row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows && col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols;
    }

    private static void printMatrix(String[][] forOutput) {
        for (String[] row : forOutput) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();

        }
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        return matrix;
    }


}
