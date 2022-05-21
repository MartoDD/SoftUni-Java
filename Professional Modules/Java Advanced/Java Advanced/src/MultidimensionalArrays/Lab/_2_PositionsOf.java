package MultidimensionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _2_PositionsOf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int number = Integer.parseInt(scanner.nextLine());

        List<String> output = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    output.add(row + " " + col);
                }
            }
        }
        if (output.isEmpty()) {
            System.out.println("not found");
        } else {
            for (String s : output) {
                System.out.println(s);
            }
        }
    }

    private static int[][] readMatrix(Scanner scanner) {

        int[] parameters = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = parameters[0];
        int cols = parameters[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
