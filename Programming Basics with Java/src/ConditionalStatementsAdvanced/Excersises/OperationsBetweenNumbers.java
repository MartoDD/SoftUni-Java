package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        String operator = scanner.next();
        double sum;

        switch (operator) {
            case "+":
                sum = n1 + n2;
                if (sum % 2 == 0) {
                    System.out.printf("%d + %d = %.0f - even", n1, n2, sum);
                } else {
                    System.out.printf("%d + %d = %.0f - odd", n1, n2, sum);
                }
                break;
            case "-":
                sum = n1 - n2;
                if (sum % 2 == 0) {
                    System.out.printf("%d - %d = %.0f - even", n1, n2, sum);
                } else {
                    System.out.printf("%d - %d = %.0f - odd", n1, n2, sum);
                }
                break;
            case "*":
                sum = n1 * n2;
                if (sum % 2 == 0) {
                    System.out.printf("%d * %d = %.0f - even", n1, n2, sum);
                } else {
                    System.out.printf("%d * %d = %.0f - odd", n1, n2, sum);
                }
                break;
            case "/":
                if (n2 == 0) {
                    System.out.printf("Cannot divide %d by zero", n1);
                } else {
                    sum = (double) n1 / (double) n2;
                    System.out.printf("%d / %d = %.2f", n1, n2, sum);
                }
                break;
            case "%":
                if (n2 == 0) {
                    System.out.printf("Cannot divide %d by zero", n1);
                } else {
                    sum = n1 % n2;
                    System.out.print(n1 + " " + "%" + " " + n2 + " " + "= ");
                    System.out.printf("%.0f", sum);
                }
        }
    }
}
