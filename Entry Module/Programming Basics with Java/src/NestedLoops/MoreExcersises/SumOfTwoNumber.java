package NestedLoops.MoreExcersises;

import java.util.Scanner;

public class SumOfTwoNumber {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        boolean isFound = false;
        int counter = 0;


        for (int i = n; i <= a; i++) {
            for (int j = n; j <= a; j++) {
                counter++;
                if (i + j == b) {
                    isFound = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", counter, i, j, b);
                    break;
                }

            }
            if (isFound) {
                break;
            }
        }
        if (!isFound) {

            System.out.printf("%d combinations - neither equals %d", counter, b);
        }
    }
}



