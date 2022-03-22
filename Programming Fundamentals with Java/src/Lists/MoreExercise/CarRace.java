package Lists.MoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> raceTrack = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        double sumOne = 0;
        double sumTwo = 0;

        for (int i = 0; i < raceTrack.size() / 2; i++) {

            if (raceTrack.get(i) != 0) {
                sumOne += raceTrack.get(i);
            } else {
                sumOne *= 0.8;
            }
        }
        for (int i = raceTrack.size() - 1; i > raceTrack.size() / 2; i--) {

            if (raceTrack.get(i) != 0) {
                sumTwo += raceTrack.get(i);
            } else {
                sumTwo *= 0.8;
            }
        }
        if (sumOne > sumTwo) {
            System.out.printf("The winner is right with total time: %.1f", sumTwo);
        } else {
            System.out.printf("The winner is left with total time: %.1f", sumOne);
        }

    }
}
