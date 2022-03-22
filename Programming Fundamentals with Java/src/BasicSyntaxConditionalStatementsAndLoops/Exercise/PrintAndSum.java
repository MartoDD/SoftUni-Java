package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class PrintAndSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int sum = 0;

        for (int i = n; i <= a; i++) {
            sum += i;
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.printf("Sum: %d", sum);
    }
}
