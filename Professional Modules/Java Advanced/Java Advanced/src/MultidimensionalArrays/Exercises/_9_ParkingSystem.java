package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _9_ParkingSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        boolean[][] matrix = new boolean[rows][cols];

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int counter = 1;
            boolean isBusy = true;

            int[] destination = Arrays.stream(input.split("\\s")).mapToInt(Integer::parseInt).toArray();
            int entryRow = destination[0];
            int destinationRow = destination[1];
            int destinationCol = destination[2];

            if (!matrix[destinationRow][destinationCol]) {
                matrix[destinationRow][destinationCol] = true;
                counter += Math.abs(entryRow - destinationRow) + destinationCol;
                System.out.println(counter);
            } else {
                int shortestDistance=Integer.MAX_VALUE;
                int column=0;
                for (int col = 1; col < cols; col++) {
                    if (!matrix[destinationRow][col]){
                        if (Math.abs(destinationCol-col)<shortestDistance){
                            shortestDistance=Math.abs(destinationCol-col);
                            column=col;
                        }else if (Math.abs(destinationCol-col)==shortestDistance){
                            if (col<column){
                                column=col;
                            }
                        }
                    }
                }
                if (shortestDistance!=Integer.MAX_VALUE){
                    counter += Math.abs(entryRow - destinationRow) + column;
                    matrix[destinationRow][column] = true;
                    isBusy = false;
                    System.out.println(counter);
                }
                if (isBusy) {
                    System.out.println("Row " + destinationRow + " full");
                }
            }


            input = scanner.nextLine();
        }

    }
}
