package MultidimensionalArrays.Exercises;

import java.util.*;

public class _7_Crossfire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<String>> matrix = createMatrix(rows, cols);

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


    private static void printMatrix(List<List<String>> matrix) {
        for (List<String> row : matrix) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();

        }

    }

    private static List<List<String>> nukeMatrix(List<List<String>> matrix, int row, int col, int radius) {

        List<List<String>> nukedMatrix = new ArrayList<>();

        for (int r = 0; r < matrix.size(); r++) {
            nukedMatrix.add(new ArrayList<>());
            for (int c = 0; c < matrix.get(r).size(); c++) {
                if (destroyed(matrix, row, col, radius, r, c)) {
                    nukedMatrix.get(r).add(matrix.get(r).get(c));
                }
            }
        }

        return nukedMatrix;
    }

    private static boolean destroyed(List<List<String>> matrix, int row, int col, int radius, int r, int c) {

        List<Integer> rowTargets = new ArrayList<>();

        for (int i = row; i < matrix.size() && i <= row + radius; i++) {
            rowTargets.add(i);
        }
        for (int i = row - 1; i >= 0 && i >= row - radius; i--) {
            rowTargets.add(i);
        }

        List<Integer> colTargets = new ArrayList<>();

        for (int i = col; i < matrix.get(r).size() && i <= col + radius; i++) {
            colTargets.add(i);
        }

        for (int i = col - 1; i >= 0 && i >= col - radius; i--) {
            colTargets.add(i);
        }

        for (Integer rowTarget : rowTargets) {
            if (rowTarget == r && c == col) {
                return false;
            }
        }
        for (Integer colTarget : colTargets) {
            if (colTarget == c && r == row) {
                return false;
            }
        }

        return true;
    }

    private static List<List<String>> createMatrix(int rows, int cols) {

        List<List<String>> matrix = new ArrayList<>();
        int number = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(String.valueOf(number));
                number++;
            }
        }


        return matrix;
    }
}
