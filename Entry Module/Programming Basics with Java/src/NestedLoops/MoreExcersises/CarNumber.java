package NestedLoops.MoreExcersises;

import java.util.Scanner;

public class CarNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int first = scanner.nextInt();
        int end = scanner.nextInt();

        for (int i = first; i <= end; i++) {
            for (int j = first; j <= end; j++) {
                for (int k = first; k <= end; k++) {
                    for (int l = first; l <= end; l++) {
                        if (((i % 2 == 0 && l % 2 != 0) || (i % 2 != 0 && l % 2 == 0)) && i > l && (j + k) % 2 == 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}
