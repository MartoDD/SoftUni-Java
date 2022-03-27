package MapsLambdaAndStreamAPI.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OddOccurrences {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Map<String, Integer> wordOccurrence = new LinkedHashMap<>();

        for (String s : input) {
            s = s.toLowerCase();
            if (!wordOccurrence.containsKey(s)) {
                wordOccurrence.put(s, 1);
            } else {
                wordOccurrence.put(s, wordOccurrence.get(s) + 1);
            }
        }
        int i = 0;
        for (Map.Entry<String, Integer> s : wordOccurrence.entrySet()) {

            if (s.getValue() % 2 != 0) {
                if (i == 0) {
                    System.out.print(s.getKey());
                    i++;
                } else {
                    System.out.print(", " + s.getKey());
                }
            }
        }
    }
}
