package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _10_RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];


        char[][] matrix = readMatrix(scanner, rows, cols);
        boolean playerWin = false;
        String input = scanner.nextLine();
        int playerRow = locatePlayerRow(matrix, cols);
        int playerCol = locatePlayerCol(matrix, cols);
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case 'L':
                    if (playerCol - 1 >= 0) {
                        playerCol--;
                    } else {
                        playerWin = true;
                    }
                    matrix = multiplyBunnies(matrix);
                    break;
                case 'R':
                    if (playerCol + 1 < matrix[0].length) {
                        playerCol++;
                    } else {
                        playerWin = true;
                    }
                    matrix = multiplyBunnies(matrix);
                    break;
                case 'U':
                    if (playerRow - 1 >= 0) {
                        playerRow--;
                    } else {
                        playerWin = true;
                    }
                    matrix = multiplyBunnies(matrix);
                    break;
                case 'D':
                    if (playerRow + 1 < matrix.length) {
                        playerRow++;
                    } else {
                        playerWin = true;
                    }
                    matrix = multiplyBunnies(matrix);
                    break;
            }
            if (playerWin) {
                break;
            } else {
                if (matrix[playerRow][playerCol] == 'B') {
                    break;
                }
            }

        }


        printMatrix(matrix);
        if (playerWin) {
            System.out.println("won: " + playerRow + " " + playerCol);
        } else {
            System.out.println("dead: " + playerRow + " " + playerCol);
        }


    }

    private static char[][] multiplyBunnies(char[][] matrix) {

        char[][] matrixMultiplied = new char[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 'B') {
                    matrixMultiplied[row][col] = 'B';
                    if ((row - 1) >= 0) {
                        matrixMultiplied[row - 1][col] = 'B';
                    }
                    if ((row + 1) < matrix.length) {
                        matrixMultiplied[row + 1][col] = 'B';
                    }
                    if ((col - 1) >= 0) {
                        matrixMultiplied[row][col - 1] = 'B';
                    }
                    if ((col + 1) < matrix[row].length) {
                        matrixMultiplied[row][col + 1] = 'B';
                    }
                }
            }
        }
        for (int row = 0; row < matrixMultiplied.length; row++) {
            for (int col = 0; col < matrixMultiplied[row].length; col++) {
                if (matrix[row][col] != 'B') {
                    matrix[row][col] = '.';
                }
            }
        }


        return matrixMultiplied;
    }

    private static int locatePlayerCol(char[][] matrix, int cols) {
        int pCol = 0;

        for (char[] strings : matrix) {
            for (int col = 0; col < cols; col++) {
                if (strings[col] == 'P') {
                    pCol = col;
                }
            }
        }
        return pCol;
    }

    private static int locatePlayerRow(char[][] matrix, int cols) {
        int pRow = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 'P') {
                    pRow = row;
                    break;
                }
            }
        }
        return pRow;


    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                if (col != 'B' && col != 'P') {
                    System.out.print(".");
                } else {
                    System.out.print(col);
                }
            }
            System.out.println();

        }

    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }


        return matrix;
    }
}
