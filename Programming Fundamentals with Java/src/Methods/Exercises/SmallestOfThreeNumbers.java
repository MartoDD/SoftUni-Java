package Methods.Exercises;

import java.util.Scanner;

public class SmallestOfThreeNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        printSmallestNumber(a, b, c);

    }

    private static void printSmallestNumber(int a, int b, int c) {

        System.out.println(Math.min(Math.min(a, b), c));
    }
}
