package Methods.Lab;

import java.util.Scanner;

public class MultiplyEvensByOdds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        int result = getMultipleOfEvenAndOdds(a);
        System.out.println(result);
    }

    private static int getMultipleOfEvenAndOdds(int a) {

        return sumOfAllEven(a) * sumOfAllOdd(a);
    }

    private static int sumOfAllOdd(int a) {
        int sum = 0;
        while (Math.abs(a) > 0) {
            int digit = a % 10;
            if (digit % 2 != 0) {
                sum += digit;
            }
            a /= 10;

        }
        return sum;
    }

    private static int sumOfAllEven(int a) {
        int sum = 0;
        while (Math.abs(a) > 0) {
            int digit = a % 10;
            if (digit % 2 == 0) {
                sum += digit;
            }
            a /= 10;

        }
        return sum;
    }
}
