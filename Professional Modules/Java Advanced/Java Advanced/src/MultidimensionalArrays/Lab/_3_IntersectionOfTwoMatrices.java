package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class _3_IntersectionOfTwoMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = readMatrix(rows, cols, scanner);
        String[][] secondMatrix = readMatrix(rows, cols, scanner);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String output = firstMatrix[row][col].equals(secondMatrix[row][col]) ? firstMatrix[row][col] : "*";
                System.out.print(output + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(int rows, int cols, Scanner scanner) {

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        return matrix;
    }
}
