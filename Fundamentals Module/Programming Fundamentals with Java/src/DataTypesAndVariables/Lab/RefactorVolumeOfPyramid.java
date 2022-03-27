package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class RefactorVolumeOfPyramid {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Length: ");
        double length = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        double width = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        double height = Double.parseDouble(scanner.nextLine());
        double v = 1 / 3.0 * width * length * height;
        System.out.printf("Pyramid Volume: %.2f", v);


    }
}
