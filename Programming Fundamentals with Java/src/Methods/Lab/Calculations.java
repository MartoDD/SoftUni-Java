package Methods.Lab;

import java.util.Scanner;

public class Calculations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        switch (operation) {
            case "add": {
                int c = add(a, b);
                System.out.println(c);
                break;
            }
            case "multiply": {
                int c = multiply(a, b);
                System.out.println(c);
                break;
            }
            case "subtract": {
                int c = subtract(a, b);
                System.out.println(c);
                break;
            }
            case "divide": {
                int c = divide(a, b);
                System.out.println(c);
                break;
            }
        }
    }

    private static int divide(int a, int b) {
        return a / b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int add(int a, int b) {
        return a + b;
    }
}
