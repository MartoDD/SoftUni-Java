package ObjectsАndClasses.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split("\\s+");

            Car car = new Car(data[0], new Engine(Integer.parseInt(data[1]), Integer.parseInt(data[2])), new Cargo(Integer.parseInt(data[3]), data[4]), new ArrayList<>());
            car.getTires().add(new Tire(Double.parseDouble(data[5]), Integer.parseInt(data[6])));
            car.getTires().add(new Tire(Double.parseDouble(data[7]), Integer.parseInt(data[8])));
            car.getTires().add(new Tire(Double.parseDouble(data[9]), Integer.parseInt(data[10])));
            car.getTires().add(new Tire(Double.parseDouble(data[11]), Integer.parseInt(data[12])));
            cars.add(car);

        }
        String input = scanner.nextLine();

        switch (input) {
            case "fragile":
                for (Car car : cars) {
                    if (car.getCargo().getType().equals("fragile")) {
                        for (Tire tire : car.getTires()) {
                            if (tire.getPressure() < 1) {
                                System.out.println(car.getModel());
                                break;
                            }
                        }
                    }
                }
                break;
            case "flamable":
                cars.stream().filter(car -> car.getEngine().getPower()>250).forEach(car -> System.out.println(car.getModel()));
                break;
        }

    }

    static class Car {
        String model;
        Engine engine;
        Cargo cargo;
        List<Tire> tires;

        public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tires = tires;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Engine getEngine() {
            return engine;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public void setCargo(Cargo cargo) {
            this.cargo = cargo;
        }

        public List<Tire> getTires() {
            return tires;
        }

        public void setTires(List<Tire> tires) {
            this.tires = tires;
        }
    }

    static class Engine {
        int speed;
        int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }
    }

    static class Cargo {
        int weigh;
        String type;

        public Cargo(int weigh, String type) {
            this.weigh = weigh;
            this.type = type;
        }

        public int getWeigh() {
            return weigh;
        }

        public void setWeigh(int weigh) {
            this.weigh = weigh;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    static class Tire {
        double pressure;
        int age;

        public Tire(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }
    }
}
