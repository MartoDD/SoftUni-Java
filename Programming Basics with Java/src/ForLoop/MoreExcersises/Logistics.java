package ForLoop.MoreExcersises;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int totalPrice = 0;
        int cargo = 0;
        int vanCargo = 0;
        int truckCargo = 0;
        int trainCargo = 0;

        for (int i = 0; i < n; i++) {

            cargo = scanner.nextInt();

            if (cargo <= 3) {
                totalPrice += 200 * cargo;
                vanCargo += cargo;
            } else if (cargo <= 11) {
                totalPrice += 175 * cargo;
                truckCargo += cargo;
            } else {
                totalPrice += 120 * cargo;
                trainCargo += cargo;
            }
        }
        int totalCargo=vanCargo + truckCargo + trainCargo;
        double avgPrice = totalPrice * 1.0 / totalCargo;
        System.out.printf("%.2f%n", avgPrice);
        System.out.printf("%.2f%%%n", vanCargo * 1.0 / totalCargo * 100);
        System.out.printf("%.2f%%%n", truckCargo * 1.0 / totalCargo * 100);
        System.out.printf("%.2f%%%n", trainCargo * 1.0 / totalCargo * 100);
    }
}
