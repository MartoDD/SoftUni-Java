package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class StrongNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int number = Integer.parseInt(input);
        int tru = number;
        int digit;
        int sum = 0;
        int fac;

        for (int i = 0; i < input.length(); i++) {
            digit = number % 10;
            fac = digit;
            if (digit == 0) {
                sum += 1;
            }
            for (int j = digit; j > 1; j--) {

                fac *= j - 1;
            }
            sum += fac;
            if (number == 2) {
                break;
            }
            number /= 10;
        }
        if (sum == tru) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
