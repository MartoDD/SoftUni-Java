package Methods.Exercises;

import java.util.Scanner;

public class TopNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        for (int i = 1; i <= a; i++) {
            printTopNumber(i);
        }
    }

    static void printTopNumber(int i) {
        int sum = 0;
        int number = i;
        boolean first = false;
        boolean second = false;
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                second = true;
            }
            sum += digit;
            number /= 10;
        }
        if (sum % 8 == 0) {
            first = true;
        }
        if (first && second) {
            System.out.println(i);
        }
    }


}
