package Methods.Lab;

import java.util.Scanner;

public class SignOfIntegerNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        printResult(n);
    }

    private static void printResult(int n) {

        if (n > 0) {
            System.out.println("The number " + n + " is positive.");
        } else if (n < 0) {
            System.out.println("The number " + n + " is negative.");
        } else {
            System.out.println("The number " + n + " is zero.");
        }
    }
}
