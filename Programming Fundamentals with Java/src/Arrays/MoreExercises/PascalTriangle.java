package Arrays.MoreExercises;

import java.util.Scanner;

public class PascalTriangle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] previousRow = {1};
        System.out.println(previousRow[0]);

        for (int i = 1; i < n; i++) {

            int[] currentRow = new int[i + 1];


            for (int j = 0; j < currentRow.length; j++) {

                if (j == 0 || j == currentRow.length - 1) {
                    currentRow[j] = 1;
                } else {
                    currentRow[j] = previousRow[j - 1] + previousRow[j];
                }
            }
            previousRow = currentRow;

            for (int c : currentRow) {
                System.out.print(c + " ");
            }
            System.out.println();


        }
    }
}
