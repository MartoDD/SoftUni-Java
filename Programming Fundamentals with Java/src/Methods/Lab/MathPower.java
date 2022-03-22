package Methods.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        System.out.println(new DecimalFormat("0.####").format(mathPower(a, b)));
    }

    private static double mathPower(double a, double b) {
        return Math.pow(a, b);
    }
}
