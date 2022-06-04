package DefiningClasses.Lab._1_CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String brand = data[0];
            String model = data[1];
            int horsePowers = Integer.parseInt(data[2]);

            Car car = new Car(brand, model, horsePowers);

            System.out.println(car.getInfo());

        }
    }
}
