package Methods.Lab;

import java.util.Scanner;

public class PrintingTriangle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            printSingleLine(i);
        }

        for (int i = n - 1; i > 0; i--) {
            printSingleLine(i);
        }

    }

    private static void printSingleLine(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
