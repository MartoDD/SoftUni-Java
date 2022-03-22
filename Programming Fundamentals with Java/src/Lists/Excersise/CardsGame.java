package Lists.Excersise;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> firstHand = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondHand = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (firstHand.size() != 0 && secondHand.size() != 0) {

            if (Objects.equals(firstHand.get(0), secondHand.get(0))) {
                firstHand.remove(0);
                secondHand.remove(0);
            } else if (firstHand.get(0) < secondHand.get(0)) {
                secondHand.add(secondHand.get(0));
                secondHand.add(firstHand.get(0));
                secondHand.remove(0);
                firstHand.remove(0);

            } else if (firstHand.get(0) > secondHand.get(0)) {
                firstHand.add(firstHand.get(0));
                firstHand.add(secondHand.get(0));
                firstHand.remove(0);
                secondHand.remove(0);
            }
        }
        int sum = 0;
        if (firstHand.size() < secondHand.size()) {
            for (Integer integer : secondHand) {
                sum += integer;
            }

            System.out.printf("Second player wins! Sum: %d", sum);
        } else {
            for (Integer integer : firstHand) {
                sum += integer;
            }
            System.out.printf("First player wins! Sum: %d", sum);

        }
    }
}
