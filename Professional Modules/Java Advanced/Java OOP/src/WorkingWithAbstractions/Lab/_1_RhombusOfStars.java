package WorkingWithAbstractions.Lab;

import java.util.Scanner;

public class _1_RhombusOfStars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= n; i++) {
            printLine(i,n);
        }
        for (int i = n-1; i >=0 ; i--) {
            printLine(i,n);
        }
    }

    private static void printLine(int i,int n) {
        for (int j = 0; j < n-i; j++) {
            System.out.print(" ");
        }
        for (int j = n-i; j < n; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
