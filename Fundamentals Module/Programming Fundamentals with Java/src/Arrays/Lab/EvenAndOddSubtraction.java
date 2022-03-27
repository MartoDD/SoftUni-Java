package Arrays.Lab;

import java.util.Scanner;

public class EvenAndOddSubtraction {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] numbers = input.split(" ");

        int sumEven = 0;
        int sumOdd = 0;

        for (String number : numbers) {
            int digit = Integer.parseInt(number);
            if (digit % 2 == 0) {
                sumEven += digit;
            } else {
                sumOdd += digit;
            }
        }
        System.out.println(sumEven - sumOdd);
    }
}
