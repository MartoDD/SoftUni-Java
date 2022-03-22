package ForLoop.Lab;

import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i <n; i++) {
            int input = scanner.nextInt();
            if (i%2==0) {
                sum1 += input;
            } else {
                sum2 += input;
            }

        }
        if (sum1 == sum2) {
            System.out.printf("Yes%nSum = %d", sum1);
        } else if (sum1 > sum2) {
            System.out.printf("No%nDiff = %d", sum1 - sum2);
        } else {
            System.out.printf("No%nDiff = %d", sum2 - sum1);
        }
    }
}
