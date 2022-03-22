package ForLoop.Excersises;

import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int tour = scanner.nextInt();
        int points = scanner.nextInt();
        double avg = 0;
        double win = 0;

        for (int i = 0; i < tour; i++) {

            String stage = scanner.next();
            switch (stage) {
                case "W":
                    points += 2000;
                    avg += 2000;
                    win++;
                    break;
                case "F":
                    points += 1200;
                    avg += 1200;
                    break;
                case "SF":
                    points += 720;
                    avg += 720;
                    break;
            }
        }
        System.out.printf("Final points: %d%nAverage points: %.0f%n%.2f", points, Math.floor(avg / tour), win / tour * 100);
        System.out.print("%");
    }
}
