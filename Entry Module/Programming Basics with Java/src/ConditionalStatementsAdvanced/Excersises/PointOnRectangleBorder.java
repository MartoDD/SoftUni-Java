package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class PointOnRectangleBorder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        boolean first = (x == x1 || x == x2) && (y >= y1 && y <= y2);
        boolean second = (y == y1 || y == y2) && (x >= x1 && x <= x2);

        if (first || second) {
            System.out.println("Border");
        } else {
            System.out.println("Inside / Outside");
        }
    }
}
