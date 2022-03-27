package ConditionalStatements.MoreExcersises;

import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        int fuelLiters = scanner.nextInt();

        if (fuelLiters >= 25) {
            if (fuelType.equals("Diesel")) {
                System.out.println("You have enough diesel.");
            } else if (fuelType.equals("Gasoline")) {
                System.out.println("You have enough gasoline.");
            } else if (fuelType.equals("Gas")) {
                System.out.println("You have enough gas.");
            } else {
                System.out.println("Invalid fuel!");
            }
        } else {
            if (fuelType.equals("Diesel")) {
                System.out.println("Fill your tank with diesel!");
            } else if (fuelType.equals("Gasoline")) {
                System.out.println("Fill your tank with gasoline!");
            } else if (fuelType.equals("Gas")) {
                System.out.println("Fill your tank with gas!");
            } else {
                System.out.println("Invalid fuel!");
            }
        }
    }
}
