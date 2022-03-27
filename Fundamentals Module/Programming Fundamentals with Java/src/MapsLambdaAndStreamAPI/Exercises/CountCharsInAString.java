package MapsLambdaAndStreamAPI.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> letters = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                if (!letters.containsKey(input.charAt(i))) {
                    letters.put(input.charAt(i), 1);
                } else {
                    letters.put(input.charAt(i), letters.get(input.charAt(i)) + 1);
                }
            }
        }

        letters.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
