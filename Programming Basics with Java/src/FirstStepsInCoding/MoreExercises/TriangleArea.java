package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double side = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double area = side * h / 2;
        System.out.printf("%.2f", area);


    }
}
