package ForLoop.MoreExcersises;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int number;
        int tempSum = 0;
        int sum = 0;
        int difference = Integer.MIN_VALUE;
        int finalDiff = Integer.MIN_VALUE;

        for (int i = 1; i <= 2 * n; i++) {

            number = scanner.nextInt();
            if (i <= 2) {
                sum += number;
            }
            tempSum += number;
            if (i % 2 == 0) {
                if (tempSum == sum) {
                    sum = tempSum;
                } else if (tempSum < sum) {
                    difference = sum - tempSum;
                } else {
                    difference = tempSum - sum;
                }
                if (difference > finalDiff) {
                    finalDiff = difference;
                }
                sum = tempSum;
                tempSum = 0;
            }
        }
        if (finalDiff > Integer.MIN_VALUE) {
            System.out.printf("No, maxdiff=%d", finalDiff);
        } else {
            System.out.printf("Yes, value=%d", sum);
        }

    }
}
