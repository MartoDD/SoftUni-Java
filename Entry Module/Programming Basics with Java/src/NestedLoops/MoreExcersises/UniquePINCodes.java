package NestedLoops.MoreExcersises;

import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();

        for (int i = 1; i <= first; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j <= second; j++) {
                    if (j == 2 || j == 3 || j == 5 || j == 7) {
                        for (int k = 1; k <= third; k++) {
                            if (k % 2 == 0) {
                                System.out.print(i + " ");
                                System.out.print(j + " ");
                                System.out.print(k);
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }
    }
}
