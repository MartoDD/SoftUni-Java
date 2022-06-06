package DefiningClasses.Exercises._5_CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            Engine engine = createEngine(input);
            String model = input[0];
            engines.put(model, engine);
        }
        n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String engineName = data[1];
            Car car = buildCar(data);
            if (engines.containsKey(engineName)) {
                Engine engine = engines.get(engineName);
                if (car != null) {
                    car.setEngine(engine);
                }
                cars.add(car);
            }
        }
        cars.forEach(System.out::println);
    }

    private static Car buildCar(String[] data) {
        String model = data[0];
        int weight;
        String color;

        switch (data.length) {
            case 2:
                return new Car(model);
            case 3:
                if (Character.isDigit(data[data.length - 1].charAt(0))) {
                    weight = Integer.parseInt(data[data.length - 1]);
                    return new Car(model, weight);
                } else {
                    color = data[data.length - 1];
                    return new Car(model, color);
                }
            case 4:
                weight = Integer.parseInt(data[2]);
                color = data[3];
                return new Car(model, weight, color);
        }
        return null;
    }

    private static Engine createEngine(String[] input) {

        String model = input[0];
        String power = input[1];
        int displacement;
        String efficiency;
        switch (input.length) {
            case 2:
                return new Engine(model, power);
            case 3:
                if (Character.isDigit(input[input.length - 1].charAt(0))) {
                    displacement = Integer.parseInt(input[input.length - 1]);
                    return new Engine(model, power, displacement);
                } else {
                    efficiency = input[input.length - 1];
                    return new Engine(model, power, efficiency);
                }
            case 4:
                displacement = Integer.parseInt(input[2]);
                efficiency = input[3];
                return new Engine(model, power, displacement, efficiency);
        }
        return null;

    }
}
