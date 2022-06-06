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
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>();

            for (int i = 5; i < 12; i+=2) {
                double tirePressure = Double.parseDouble(data[i]);
                double tireAge = Double.parseDouble(data[i + 1]);

                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);

            }
            Car car = new Car(model, cargo, engine, tires);
            cars.add(car);

        }

        String fragileOrNot = scanner.nextLine();

        cars.stream().filter(car -> car.checkStatus(fragileOrNot)).forEach(car -> System.out.println(car.getModel()));



    }
}
