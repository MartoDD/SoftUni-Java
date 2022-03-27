package ObjectsАndClasses.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSalesman {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Engine engine = new Engine();
            engine.setModel(input[0]);
            engine.setPower(Integer.parseInt(input[1]));
            if (input.length == 2) {
                engine.setDisplacement("n/a");
                engine.setEfficiency("n/a");
            } else if (input.length == 3) {
                String test = input[2];
                if (Character.isDigit(test.charAt(0))) {
                    engine.setDisplacement(input[2]);
                    engine.setEfficiency("n/a");
                } else {
                    engine.setDisplacement("n/a");
                    engine.setEfficiency(input[2]);
                }
            } else {
                engine.setEfficiency(input[3]);
                engine.setDisplacement(input[2]);
            }
            engines.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setModel(data[0]);
            engines.forEach(engine -> {
                if (engine.getModel().equals(data[1])) {
                    car.setEngine(engine);
                }
            });
            if (data.length == 2) {
                car.setWight("n/a");
                car.setColor("n/a");
            } else if (data.length == 3) {
                String test = data[2];
                if (Character.isDigit(test.charAt(0))) {
                    car.setWight(data[2]);
                    car.setColor("n/a");
                } else {
                    car.setWight("n/a");
                    car.setColor(data[2]);
                }
            } else {
                car.setColor(data[3]);
                car.setWight(data[2]);
            }

            cars.add(car);

        }
        cars.forEach(car -> System.out.println(car.print()));


    }

    static class Car {
        String model;
        Engine engine;
        String wight;
        String color;


        public void setModel(String model) {
            this.model = model;
        }


        public void setEngine(Engine engine) {
            this.engine = engine;
        }


        public void setWight(String wight) {
            this.wight = wight;
        }


        public void setColor(String color) {
            this.color = color;
        }

        String print() {
            return String.format("%s:" +
                    "%n%s" +
                    "%nWeight: %s" +
                    "%nColor: %s", this.model, this.engine.print(), this.wight, this.color);
        }
    }

    static class Engine {
        String model;
        int power;
        String displacement;
        String efficiency;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }


        public void setPower(int power) {
            this.power = power;
        }


        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }


        public void setEfficiency(String efficiency) {
            this.efficiency = efficiency;
        }

        String print() {
            return String.format("%s:" +
                    "%n   Power: %d" +
                    "%n   Displacement: %s" +
                    "%n   Efficiency: %s", this.model, this.power, this.displacement, this.efficiency);
        }

    }
}
