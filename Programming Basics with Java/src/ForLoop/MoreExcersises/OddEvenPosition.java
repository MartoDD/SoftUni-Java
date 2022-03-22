package ForLoop.MoreExcersises;

import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double input;
        double oddSum = 0;
        double evenSum = 0;
        double oddMin = Double.MAX_VALUE;
        double oddMax = Double.NEGATIVE_INFINITY;
        double evenMin = Double.MAX_VALUE;
        double evenMax = Double.NEGATIVE_INFINITY;

        for (int i = 1; i <= n; i++) {

            input = scanner.nextDouble();

            if (i % 2 != 0) {
                oddSum += input;
                if (oddMax < input) {
                    oddMax = input;
                }
                if (oddMin > input) {
                    oddMin = input;
                }
            } else {
                evenSum += input;
                if (evenMax < input) {
                    evenMax = input;
                }
                if (evenMin > input) {
                    evenMin = input;
                }
            }
        }
        System.out.printf("OddSum=%.2f,%n", oddSum);
        if (oddMin != Double.MAX_VALUE) {
            System.out.printf("OddMin=%.2f,%n", oddMin);
        } else {
            System.out.println("OddMin=No,");
        }
        if (oddMax != Double.NEGATIVE_INFINITY) {
            System.out.printf("OddMax=%.2f,%n", oddMax);
        } else {
            System.out.println("OddMax=No,");
        }

        System.out.printf("EvenSum=%.2f,%n", evenSum);
        if (evenMin != Double.MAX_VALUE) {
            System.out.printf("EvenMin=%.2f,%n", evenMin);
        } else {
            System.out.println("EvenMin=No,");
        }
        if (evenMax != Double.NEGATIVE_INFINITY) {
            System.out.printf("EvenMax=%.2f%n", evenMax);
        } else {
            System.out.println("EvenMax=No");
        }


    }
}
