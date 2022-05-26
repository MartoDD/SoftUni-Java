package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _1_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {

            String[] data = input.split(", ");
            String instruction = data[0];
            String car = data[1];

            if (instruction.equals("IN")) {
                cars.add(car);
            } else {
                cars.remove(car);
            }
            input = scanner.nextLine();
        }

        if (cars.size() > 0) {
            for (String car : cars) {
                System.out.println(car);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }

    }
}
