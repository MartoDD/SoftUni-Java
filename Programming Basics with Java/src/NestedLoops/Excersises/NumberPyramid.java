package NestedLoops.Excersises;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int counter = 1;

        for (int rows = 1; rows <= n; rows++) {
            for (int col = 1; col <= rows; col++) {

                System.out.print(counter + " ");
                counter++;
                if (counter > n) {
                    break;
                }
            }
            if (counter > n) {
                break;
            }
            System.out.println();
        }

    }
}
