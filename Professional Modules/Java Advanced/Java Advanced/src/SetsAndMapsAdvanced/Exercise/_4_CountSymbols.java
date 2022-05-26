package SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_CountSymbols {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> chars = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {

            char symbol = input.charAt(i);
            chars.putIfAbsent(symbol, 0);
            chars.put(symbol, chars.get(symbol) + 1);

        }
        for (var entry : chars.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
