package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> houses = Arrays.stream(scanner.nextLine().split("@")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        int startingIndex = 0;

        while (!input.equals("Love!")) {
            String[] commands = input.split(" ");
            int value = Integer.parseInt(commands[1]);

            if ((startingIndex + value) >= houses.size()) {
                startingIndex = 0;

            } else {
                startingIndex += value;
            }
            if (houses.get(startingIndex) != 0) {
                houses.set(startingIndex, houses.get(startingIndex) - 2);
                if (houses.get(startingIndex) == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", startingIndex);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", startingIndex);
            }
            input = scanner.nextLine();
        }

        boolean didNotFail = true;

        for (Integer house : houses) {
            if (house != 0) {
                didNotFail = false;
                break;
            }
        }
        System.out.printf("Cupid's last position was %d.%n", startingIndex);

        if (didNotFail) {
            System.out.println("Mission was successful.");
        } else {
            int failed = 0;
            for (Integer house : houses) {
                if (house != 0) {
                    failed++;
                }
            }
            System.out.printf("Cupid has failed %d places.", failed);
        }
    }
}
