package Methods.Exercises;

import java.util.Scanner;

public class FactorialDivision {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.printf("%.2f", factorial(a)/factorial(b));
    }

    public static double factorial(double a) {
        double sum = 1.0;
        for (double i = a; i > 0; i--) {
            sum *= i;
        }
        return sum;
    }
}
