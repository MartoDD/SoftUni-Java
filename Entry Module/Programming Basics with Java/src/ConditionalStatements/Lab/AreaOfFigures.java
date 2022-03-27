package ConditionalStatements.Lab;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        double a = scanner.nextDouble();


        if (type.equals("square")){
            double result = a * a;
            System.out.printf("%.3f", result);
        }else if (type.equals("rectangle")) {
            double b = scanner.nextDouble();
            double result = a * b;
            System.out.printf("%.3f", result);
        }else if (type.equals("circle")) {
            double result = Math.PI * a * a;
            System.out.printf("%.3f", result);
        }else {
            double b = scanner.nextDouble();
            double result = a * b / 2;
            System.out.printf("%.3f", result);
        }


    }
}
