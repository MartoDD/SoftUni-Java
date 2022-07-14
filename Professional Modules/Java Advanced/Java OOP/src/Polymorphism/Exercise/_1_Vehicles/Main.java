package Polymorphism.Exercise._1_Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] carInput = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]));

        String[] truckInput = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]));

        int n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            switch (input[0]) {
                case "Drive":
                    if (input[1].equals("Car")) {
                        car.drive(Double.parseDouble(input[2]));
                    } else if (input[1].equals("Truck")) {
                        truck.drive(Double.parseDouble(input[2]));
                    }
                    break;
                case "Refuel":
                    if (input[1].equals("Car")) {
                        car.refuel(Double.parseDouble(input[2]));
                    } else if (input[1].equals("Truck")) {
                        truck.refuel(Double.parseDouble(input[2]));
                    }
                    break;
            }

        }
        System.out.printf("Car: %.2f%n",car.getFuelQuantity());
        System.out.printf("Truck: %.2f",truck.getFuelQuantity());

    }
}
