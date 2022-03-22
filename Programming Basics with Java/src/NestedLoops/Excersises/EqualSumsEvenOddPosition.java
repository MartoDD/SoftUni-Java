package NestedLoops.Excersises;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());

        for (int i = first; i <= second; i++) {
            String number = "" + i;
            int evenSum = 0;
            int oddSum = 0;
            for (int j = 0; j < number.length(); j++) {
                int digit = Integer.parseInt("" + number.charAt(j));
                if ((j + 1) % 2 == 0) {
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
            }
            if (evenSum == oddSum) {
                System.out.print(i + " ");
            }
        }
    }
}
