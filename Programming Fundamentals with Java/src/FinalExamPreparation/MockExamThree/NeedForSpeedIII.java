package FinalExamPreparation.MockExamThree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            Car car = new Car(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            cars.add(car);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] instructions = input.split(" : ");
            String command = instructions[0];
            String car;
            int distance;
            int fuel;
            int kilometers;
            switch (command) {
                case "Drive":
                    car = instructions[1];
                    distance = Integer.parseInt(instructions[2]);
                    fuel = Integer.parseInt(instructions[3]);
                    boolean caMadeTheRide = false;
                    boolean toSell = false;
                    for (Car car1 : cars) {
                        if (car1.getModel().equals(car)) {
                            if (car1.getFuel() >= fuel) {
                                car1.setMileage(car1.getMileage() + distance);
                                car1.setFuel(car1.getFuel() - fuel);
                                caMadeTheRide = true;
                            }
                            if (car1.getMileage() >= 100000) {
                                toSell = true;
                                cars.remove(car1);
                            }
                            if (toSell) {
                                break;
                            }
                        }
                    }
                    if (!caMadeTheRide) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                    }
                    if (toSell) {
                        System.out.println("Time to sell the " + car + "!");
                    }
                    break;
                case "Refuel":
                    car = instructions[1];
                    fuel = Integer.parseInt(instructions[2]);
                    for (Car car1 : cars) {
                        if (car1.getModel().equals(car)) {
                            if (car1.getFuel() + fuel <= 75) {
                                car1.setFuel(car1.getFuel() + fuel);
                                System.out.println(car + " refueled with " + fuel + " liters");
                            } else {
                                int toRefuel = 75 - car1.getFuel();
                                car1.setFuel(75);
                                System.out.println(car + " refueled with " + toRefuel + " liters");
                            }
                        }
                    }

                    break;
                case "Revert":
                    car = instructions[1];
                    kilometers = Integer.parseInt(instructions[2]);
                    for (Car car1 : cars) {
                        if (car1.getModel().equals(car)) {
                            if (car1.getMileage() - kilometers >= 10000) {
                                car1.setMileage(car1.getMileage() - kilometers);
                                System.out.println(car + " mileage decreased by " + kilometers + " kilometers");
                            } else {
                                car1.setMileage(10000);
                            }
                        }
                    }

                    break;
            }

            input = scanner.nextLine();
        }
        for (Car car : cars) {
            System.out.println(car.print());
        }

    }

    static class Car {
        String model;
        int mileage;
        int fuel;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        public Car(String model, int mileage, int fuel) {
            this.model = model;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        String print() {
            return String.format("%s -> Mileage: %d kms, Fuel in the tank: %d lt.", this.model, this.mileage, this.fuel);
        }
    }
}
