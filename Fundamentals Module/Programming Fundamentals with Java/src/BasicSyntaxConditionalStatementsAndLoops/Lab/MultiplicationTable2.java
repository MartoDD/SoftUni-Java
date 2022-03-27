package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class MultiplicationTable2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int multiplier = scanner.nextInt();

        if (multiplier >= 10) {
            System.out.printf("%d X %d = %d", n, multiplier, n * multiplier);
        } else {

            for (int i = multiplier; i <= 10; i++) {
                System.out.printf("%d X %d = %d%n", n, i, n * i);
            }
        }
    }
}
