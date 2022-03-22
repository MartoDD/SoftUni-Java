package ConditionalStatements.MoreExcersises;

import java.util.Scanner;

public class FuelTankPart2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double fuelQuantity = scanner.nextDouble();
        String discount = scanner.next();

        if ((fuelQuantity >= 20) && (fuelQuantity <= 25)) {
            if (fuelType.equals("Gasoline")) {
                if (discount.equals("Yes")) {
                    System.out.printf("%.2f lv.", (fuelQuantity * 2.04) * 0.92);
                } else {
                    System.out.printf("%.2f lv.", (fuelQuantity * 2.22) * 0.92);
                }
            } else if (fuelType.equals("Diesel")) {
                if (discount.equals("Yes")) {
                    System.out.printf("%.2f lv.", (fuelQuantity * 2.21) * 0.92);
                } else {
                    System.out.printf("%.2f lv.", (fuelQuantity * 2.33) * 0.92);
                }
            } else {
                if (discount.equals("Yes")) {
                    System.out.printf("%.2f lv.", (fuelQuantity * 0.85) * 0.92);
                } else {
                    System.out.printf("%.2f lv.", (fuelQuantity * 0.93) * 0.92);
                }
            }
        } else if (fuelQuantity > 25) {
            if (fuelType.equals("Gasoline")) {
                if (discount.equals("Yes")) {
                    System.out.printf("%.2f lv.", (fuelQuantity * 2.04) * 0.90);
                } else {
                    System.out.printf("%.2f lv.", (fuelQuantity * 2.22) * 0.90);
                }
            } else if (fuelType.equals("Diesel")) {
                if (discount.equals("Yes")) {
                    System.out.printf("%.2f lv.", (fuelQuantity * 2.21) * 0.90);
                } else {
                    System.out.printf("%.2f lv.", (fuelQuantity * 2.33) * 0.90);
                }
            } else {
                if (discount.equals("Yes")) {
                    System.out.printf("%.2f lv.", (fuelQuantity * 0.85) * 0.90);
                } else {
                    System.out.printf("%.2f lv.", (fuelQuantity * 0.93) * 0.90);
                }
            }
        } else {
            if (fuelType.equals("Gasoline")) {
                if (discount.equals("Yes")) {
                    System.out.printf("%.2f lv.", (fuelQuantity * 2.04));
                } else {
                    System.out.printf("%.2f lv.", (fuelQuantity * 2.22));
                }
            } else if (fuelType.equals("Diesel")) {
                if (discount.equals("Yes")) {
                    System.out.printf("%.2f lv.", (fuelQuantity * 2.21));
                } else {
                    System.out.printf("%.2f lv.", (fuelQuantity * 2.33));
                }
            } else {
                if (discount.equals("Yes")) {
                    System.out.printf("%.2f lv.", (fuelQuantity * 0.85));
                } else {
                    System.out.printf("%.2f lv.", (fuelQuantity * 0.93));
                }
            }
        }
    }
}
