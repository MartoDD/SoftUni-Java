package SetsAndMapsAdvanced.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _7_HandsOfCards {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {

            String[] data = input.split(": ");
            String name = data[0];
            List<String> cards = Arrays.stream(data[1].split(", ")).collect(Collectors.toList());
            players.putIfAbsent(name, new LinkedHashSet<>());
            players.get(name).addAll(cards);

            input = scanner.nextLine();
        }

        for (var entry : players.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            int sum = 0;
            for (String s : entry.getValue()) {
                char first = s.charAt(0);
                char last = s.charAt(s.length() - 1);
                int multiplier = findMultiplier(last);

                sum = getSum(sum, first, multiplier);
            }
            System.out.println(sum);

        }

    }

    private static int getSum(int sum, char first, int multiplier) {
        switch (first) {
            case '2':
                sum += 2 * multiplier;
                break;
            case '3':
                sum += 3 * multiplier;
                break;
            case '4':
                sum += 4 * multiplier;
                break;
            case '5':
                sum += 5 * multiplier;
                break;
            case '6':
                sum += 6 * multiplier;
                break;
            case '7':
                sum += 7 * multiplier;
                break;
            case '8':
                sum += 8 * multiplier;
                break;
            case '9':
                sum += 9 * multiplier;
                break;
            case '1':
                sum += 10 * multiplier;
                break;
            case 'J':
                sum += 11 * multiplier;
                break;
            case 'Q':
                sum += 12 * multiplier;
                break;
            case 'K':
                sum += 13 * multiplier;
                break;
            case 'A':
                sum += 14 * multiplier;
                break;
        }
        return sum;
    }

    private static int findMultiplier(char last) {
        int multiplier = 0;
        switch (last) {
            case 'S':
                multiplier = 4;
                break;
            case 'H':
                multiplier = 3;
                break;
            case 'D':
                multiplier = 2;
                break;
            case 'C':
                multiplier = 1;
                break;
        }
        return multiplier;
    }
}
