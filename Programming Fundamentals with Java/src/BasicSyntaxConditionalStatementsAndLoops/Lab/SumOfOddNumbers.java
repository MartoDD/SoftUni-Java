package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class SumOfOddNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int counter = 0;
        int sum = 0;

        for (int i = 1; ; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                counter++;
                sum += i;
            }
            if (counter >= n) {
                break;
            }
        }
        System.out.printf("Sum: %d", sum);
    }
}
