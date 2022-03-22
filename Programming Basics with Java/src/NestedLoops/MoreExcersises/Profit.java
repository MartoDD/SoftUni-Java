package NestedLoops.MoreExcersises;

import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int one = scanner.nextInt();
        int two = scanner.nextInt();
        int five = scanner.nextInt();
        int targetSum = scanner.nextInt();

        for (int i = 0; i <= one; i++) {
            for (int j = 0; j <= two; j++) {
                for (int k = 0; k <=five; k++) {
                    if (i + j * 2 + k * 5 == targetSum) {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n", i, j, k, targetSum);
                    }
                }
            }
        }

    }
}
