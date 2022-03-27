package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class Snowballs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int snow = 0;
        int time = 0;
        int quality = 0;
        double value = 0;

        for (int i = 0; i < n; i++) {

            int snowballSnow = scanner.nextInt();
            int snowballTime = scanner.nextInt();
            int snowballQuality = scanner.nextInt();

            double snowballValue = Math.pow((snowballSnow / (double) snowballTime), snowballQuality);

            if (value <= snowballValue) {
                value = snowballValue;
                snow = snowballSnow;
                time = snowballTime;
                quality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", snow, time, value, quality);

    }
}
