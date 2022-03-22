package ConditionalStatements.MoreExcersises;

import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int freeDays = scanner.nextInt();
        int workDays = 365 - freeDays;
        int playTime = freeDays * 127 + workDays * 63;
        int extraHours;
        int extraMinutes;

        if (playTime <= 30000) {
            System.out.println("Tom sleeps well");
            extraHours = (30000 - playTime) / 60;
            extraMinutes = (30000 - playTime) % 60;
            System.out.printf("%d hours and %d minutes less for play", extraHours, extraMinutes);
        } else {
            System.out.println("Tom will run away");
            extraHours = (playTime - 30000) / 60;
            extraMinutes = (playTime - 30000) % 60;
            System.out.printf("%d hours and %d minutes more for play", extraHours, extraMinutes);
        }
    }
}
