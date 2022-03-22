package Methods.Lab;

import java.util.Scanner;

public class CalculateRectangleArea {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double width = scanner.nextDouble();
        double height = scanner.nextDouble();
        double area = getArea(width, height);
        System.out.printf("%.0f", area);
    }

    private static double getArea(double a, double b) {
        return a * b;
    }
}
