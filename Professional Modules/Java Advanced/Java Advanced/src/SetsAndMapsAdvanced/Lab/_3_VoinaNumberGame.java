package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _3_VoinaNumberGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        int rounds = 0;
        while (firstPlayer.size() > 0 && secondPlayer.size() > 0) {
            rounds++;
            if (rounds == 50) {
                break;
            }

            Iterator<Integer> firstPlayerIterator = firstPlayer.iterator();
            int firstCard = firstPlayerIterator.next();
            firstPlayerIterator.remove();

            Iterator<Integer> secondPlayerIterator = secondPlayer.iterator();
            int secondCard = secondPlayerIterator.next();
            secondPlayerIterator.remove();

            if (firstCard > secondCard) {
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            } else if (secondCard > firstCard) {
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }

        }
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }


    }
}
