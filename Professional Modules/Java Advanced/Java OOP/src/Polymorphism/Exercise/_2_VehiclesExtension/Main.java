package Polymorphism.Exercise._2_VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Car car = null;
        Truck truck = null;
        Bus bus = null;
        try {

            String[] carInput = scanner.nextLine().split("\\s+");
            car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]), Double.parseDouble(carInput[3]));

            String[] truckInput = scanner.nextLine().split("\\s+");
            truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]), Double.parseDouble(truckInput[3]));

            String[] busInput = scanner.nextLine().split("\\s+");
            bus = new Bus(Double.parseDouble(busInput[1]), Double.parseDouble(busInput[2]), Double.parseDouble(busInput[3]));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        int n =Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            try {
                executeCommand(input, car, truck, bus);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }

    private static void executeCommand(String[] input, Car car, Truck truck, Bus bus) {

        String command = input[0];
        String vehicle = input[1];
        double quantity = Double.parseDouble(input[2]);
        VehicleImpl vehicleImpl1 =null;
        switch (command) {
            case "Drive":
                vehicleImpl1 =getType(vehicle,car,truck,bus);
                System.out.println(vehicleImpl1.drive(quantity));
                break;
            case "Refuel":
                vehicleImpl1 =getType(vehicle,car,truck,bus);
                vehicleImpl1.refuel(quantity);
                break;
            case "DriveEmpty":
                System.out.println(bus.driveEmpty(quantity));
                break;
        }
    }

    private static VehicleImpl getType(String vehicle, Car car, Truck truck, Bus bus) {
        switch (vehicle){
            case "Car":
                return car;
            case "Truck":
                return truck;
            case "Bus":
                return bus;
            default:throw  new IllegalArgumentException();
        }
    }
}
