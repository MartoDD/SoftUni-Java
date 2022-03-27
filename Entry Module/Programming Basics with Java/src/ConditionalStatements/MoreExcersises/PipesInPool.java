package ConditionalStatements.MoreExcersises;

import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int poolVolume = scanner.nextInt();
        int p1 = scanner.nextInt();
        int p2 = scanner.nextInt();
        double hours = scanner.nextDouble();
        double p1Volume = p1 * hours;
        double p2Volume = p2 * hours;
        double waterVolume = p1Volume + p2Volume;
        String percent = "%";
        if (poolVolume >= waterVolume) {

            double percentWater = (waterVolume / poolVolume) * 100;
            double percentP1 = (p1Volume / waterVolume) * 100;
            double percentP2 = (p2Volume / waterVolume) * 100;
            System.out.printf("The pool is %.2f%s full. Pipe 1: %.2f%s. Pipe 2: %.2f%s.", percentWater, percent, percentP1, percent, percentP2, percent);
        } else {
            System.out.printf("For %.2f hours the pool overflows with  %.2f liters.", hours, waterVolume - poolVolume);
        }
    }
}
