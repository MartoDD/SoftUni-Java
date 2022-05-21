package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _1_CompareMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        String output = areMatrixesEqual(firstMatrix, secondMatrix) ? "equal" : "not equal";

        System.out.println(output);

    }

    private static boolean areMatrixesEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            } else {
                for (int col = 0; col < firstMatrix[row].length; col++) {
                    if (firstMatrix[row][col] != secondMatrix[row][col]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int[][] readMatrix(Scanner scanner) {

        String[] parameters = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(parameters[0]);
        int cols = Integer.parseInt(parameters[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
