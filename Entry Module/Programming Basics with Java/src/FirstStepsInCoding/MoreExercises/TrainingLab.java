package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double w = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double wCm = w * 100;
        double hCm = (h * 100) - 100;

        double rows = Math.floor(wCm / 120.0);
        double desksPerRow = Math.floor(hCm / 70.0);
        double slots = rows * desksPerRow - 3.0;

        System.out.println(slots);


    }
}
