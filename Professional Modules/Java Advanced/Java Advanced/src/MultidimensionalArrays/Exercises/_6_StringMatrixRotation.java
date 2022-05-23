package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _6_StringMatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String numbersOnly = text.replaceAll("[^0-9]+", "");
        int degree = Integer.parseInt(numbersOnly);
        int timesToRotate = degree / 90;


        String input = scanner.nextLine();
        List<String> words = new ArrayList<>();
        int longestWord = Integer.MIN_VALUE;

        while (!input.equals("END")) {
            words.add(input);
            if (input.length() > longestWord) {
                longestWord = input.length();
            }
            input = scanner.nextLine();
        }

        char[][] matrix = new char[words.size()][longestWord];
        matrix=readMatrix(words, matrix);

        for (int i = 1; i <= timesToRotate; i++) {
            matrix = rotateMatrix(matrix, longestWord, i);
        }

        printMatrix(matrix);


    }

    private static char[][] readMatrix(List<String> words, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < words.get(row).length(); col++) {
                matrix[row][col] = words.get(row).charAt(col);
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] rotatedMatrix) {
        for (char[] matrix : rotatedMatrix) {
            for (char c : matrix) {
                System.out.print(c != 0 ? c : "" + " ");
            }
            System.out.println();
        }

    }

    private static char[][] rotateMatrix(char[][] matrix, int longestWord, int i) {

        int rows;
        int cols;
        if (i % 2 != 0) {
            cols = matrix.length;
            rows = longestWord;
        } else {
            cols = longestWord;
            rows = matrix[0].length;
        }

        char[][] rotatedMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rotatedMatrix[row][col] = matrix[(matrix.length - 1) - col][row];
            }
        }

        return rotatedMatrix;
    }
}
