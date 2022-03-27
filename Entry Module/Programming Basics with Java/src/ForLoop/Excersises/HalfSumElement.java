package ForLoop.Excersises;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;
        int input;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            input = scanner.nextInt();
            sum += input;

            if (max < input) {
                max = input;
            }
        }
        if (sum - max == max) {
            System.out.printf("Yes%nSum = %d", max);
        } else if ((sum - max) > max) {
            System.out.printf("No%nDiff = %d", (sum - max) - max);
        } else {
            System.out.printf("No%nDiff = %d", max - (sum - max));
        }
    }
}
