package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _7_Crossfire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = createMatrix(rows, cols);

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {

            int[] parameters = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = parameters[0];
            int col = parameters[1];
            int radius = parameters[2];

            matrix = nukeMatrix(matrix, row, col, radius);


            input = scanner.nextLine();
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

    private static String[][] nukeMatrix(String[][] matrix, int row, int col, int radius) {

        String[][] nukedMatrix = new String[matrix.length][matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (destroyed(matrix, row, col, radius, r, c)) {
                    nukedMatrix[r][c] = matrix[r][c];
                }else {
                    nukedMatrix[r][c]="";
                }
            }
        }

        return nukedMatrix;
    }

    private static boolean destroyed(String[][] matrix, int row, int col, int radius, int r, int c) {

        List<Integer> rowTargets = new ArrayList<>();

        for (int i = row; i < matrix.length && i <= row + radius; i++) {
            rowTargets.add(i);
        }
        for (int i = row-1; i >= 0 && i >= row - radius; i--) {
            rowTargets.add(i);
        }

        List<Integer> colTargets = new ArrayList<>();

        for (int i = col; i < matrix[0].length && i <= col + radius; i++) {
            colTargets.add(i);
        }

        for (int i = col-1; i >= 0 && i >= col - radius; i--) {
            colTargets.add(i);
        }

        for (Integer rowTarget : rowTargets) {
            if (rowTarget==r && c==col){
                return false;
            }
        }
        for (Integer colTarget : colTargets) {
            if (colTarget==c && r==row){
                return false;
            }
        }


        return true;
    }

    private static String[][] createMatrix(int rows, int cols) {

        String[][] matrix = new String[rows][cols];
        int number = 1;
        for (String[] row : matrix) {
            for (int col = 0; col < row.length; col++) {
                row[col] = String.valueOf(number);
                number++;
            }
        }


        return matrix;
    }
}
