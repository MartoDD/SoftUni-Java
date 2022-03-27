package Methods.Lab;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.0f", getResult(a, b, operator));
    }

    private static double getResult(double a, double b, String operator) {

        switch (operator) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "/":
                return a / b;
            case "-":
                return a - b;
        }
        return 0;
    }
}
