package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class _7_FindTheRealQueen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                String current = matrix[row][col];
                if (current.equals("q")) {
                    if (checkIfValid(matrix, row, col)) {
                        System.out.println(row + " " + col);
                    }
                }
            }
        }
    }

    private static boolean checkIfValid(String[][] matrix, int row, int col) {
        if (col < 7) {
            for (int i = col + 1; i < 8; i++) {        //на дясно
                if (matrix[row][i].equals("q")) {
                    return false;
                }
            }
        }
        for (int i = 0; i < col; i++) {          //на ляво
            if (matrix[row][i].equals("q")) {
                return false;
            }
        }
        if (row < 7) {
            for (int i = row + 1; i < 8; i++) {     //надолу
                if (matrix[i][col].equals("q")) {
                    return false;
                }
            }
        }
        for (int i = 0; i < row; i++) {         //нагоре
            if (matrix[i][col].equals("q")) {
                return false;
            }
        }
        if (col < 7 && row < 7) {
            int index = col + 1;                     //надолу дясно
            for (int i = row + 1; i < 8 && index < 8; i++, index++) {
                if (matrix[i][index].equals("q")) {
                    return false;
                }
            }
            if (row > 0) {
                index = col + 1;                       //нагоре дясно
                for (int i = row - 1; i >= 0 && index < 8; i--, index++) {
                    if (matrix[i][index].equals("q")) {
                        return false;
                    }
                }
            }
        }
        if (col > 0 && row < 7) {                               //надолу ляво
            int index = col - 1;
            for (int i = row + 1; i < 8 && index >= 0; i++, index--) {
                if (matrix[i][index].equals("q")) {
                    return false;
                }
            }
            if (row > 0) {
                index = col - 1;                       // нагоре ляво
                for (int i = row - 1; i >= 0 && index >= 0; i--, index--) {
                    if (matrix[i][index].equals("q")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static String[][] readMatrix(Scanner scanner) {
        String[][] matrix = new String[8][8];
        for (int row = 0; row < 8; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }
}
