package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class BeerKegs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String biggest = "";
        double biggestK = 0;
        for (int i = 0; i < n; i++) {

            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double v = Math.PI * radius * radius * height;
            if (v > biggestK) {
                biggestK = v;
                biggest = model;
            }

        }
        System.out.println(biggest);
    }
}
