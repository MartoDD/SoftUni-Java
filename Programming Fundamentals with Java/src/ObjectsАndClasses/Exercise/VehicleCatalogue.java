package ObjectsАndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int totalCar = 0;
        int carCount = 0;
        int totalTruck = 0;
        int truckCount = 0;

        String input = scanner.nextLine();
        List<Vehicle> catalogue = new ArrayList<>();
        while (!input.equals("End")) {
            String[] info = input.split("\\s+");
            Vehicle vehicle = new Vehicle(info[0], info[1], info[2], Integer.parseInt(info[3]));
            if (vehicle.getType().equals("car")) {
                totalCar += vehicle.getHorsePower();
                carCount++;
            } else if (vehicle.getType().equals("truck")) {
                totalTruck += vehicle.getHorsePower();
                truckCount++;
            }
            catalogue.add(vehicle);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("Close the Catalogue")) {

            for (Vehicle vehicle : catalogue) {
                if (vehicle.getModel().equals(input)) {
                    System.out.println(vehicle.print());
                }
            }

            input = scanner.nextLine();
        }
        if (totalCar == 0) {
            System.out.println("Cars have average horsepower of: 0.00.");
        } else {
            System.out.printf("Cars have average horsepower of: %.2f.%n", (double) totalCar / carCount);
        }
        if (totalTruck == 0) {
            System.out.println("Trucks have average horsepower of: 0.00.");
        } else {
            System.out.printf("Trucks have average horsepower of: %.2f.%n", (double) totalTruck / truckCount);
        }
    }

    static class Vehicle {
        String type;
        String model;
        String color;
        int horsePower;

        public Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getModel() {
            return model;
        }

        public String getType() {
            return type;
        }

        public String getColor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        String print() {
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", getType().toUpperCase().charAt(0) + getType().substring(1), this.model, this.color, this.horsePower);
        }
    }
}
