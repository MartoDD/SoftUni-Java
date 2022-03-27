package ForLoop.Lab;

import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 1; i <= 2 * n; i++) {
            int input = scanner.nextInt();
            if (i <= n) {
                sum1 += input;
            } else {
                sum2 += input;
            }

        }
        if (sum1 == sum2) {
            System.out.printf("Yes, sum = %d", sum1);
        } else if (sum1 > sum2) {
            System.out.printf("No, diff = %d", sum1 - sum2);
        } else {
            System.out.printf("No, diff = %d", sum2 - sum1);
        }
    }
}
