package DefiningClasses.Exercises._3_SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int fuelAmount = Integer.parseInt(data[1]);
            double fuelCost = Double.parseDouble(data[2]);

            Car car = new Car(model, fuelAmount, fuelCost);

            cars.put(model, car);

        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] instructions = input.split("\\s+");

            String model = instructions[1];
            int kilometers = Integer.parseInt(instructions[2]);

            cars.get(model).Drive(kilometers);

            input = scanner.nextLine();
        }

        cars.forEach((k, v) -> System.out.println(v.printInfo()));

    }
}
