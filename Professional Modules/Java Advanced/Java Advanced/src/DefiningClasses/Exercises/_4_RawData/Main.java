package DefiningClasses.Exercises._4_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            List<Tire> tires = new ArrayList<>();
            for (int i = 5; i < 12; i++) {
                double tirePressure = Double.parseDouble(data[i]);
                double tireAge = Double.parseDouble(data[i + 1]);

                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);

            }
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Engine engine = new Engine(engineSpeed, enginePower);
            Car car = new Car(model, cargo, engine, new ArrayList<>());
            car.getTires().addAll(tires);
            cars.add(car);

        }

        String fragileOrNot = scanner.nextLine();

        cars.stream().filter(car -> car.checkStatus(fragileOrNot)).forEach(car -> System.out.println(car.getModel()));


    }
}
