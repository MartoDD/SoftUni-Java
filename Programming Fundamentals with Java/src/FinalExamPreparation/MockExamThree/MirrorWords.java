package FinalExamPreparation.MockExamThree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regEx = "([@#])(?<one>[A-Za-z]{3,})\\1\\1(?<two>[A-Za-z]{3,})\\1";
        Map<Integer, String> wordPairs = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            StringBuilder wordOne = new StringBuilder(matcher.group("one"));
            String wordTwo = matcher.group("two");
            count++;
            if (wordOne.reverse().toString().equals(wordTwo)) {
                wordPairs.put(count, wordOne.reverse() + " <=> " + wordTwo);
            }
        }
        if (count == 0) {
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        } else if (wordPairs.size() == 0) {
            System.out.println(count + " word pairs found!");
            System.out.println("No mirror words!");
        } else {
            System.out.println(count + " word pairs found!");
            System.out.println("The mirror words are:");
            int c = 0;
            for (Map.Entry<Integer, String> integerStringEntry : wordPairs.entrySet()) {
                if (c == 0) {
                    System.out.print(integerStringEntry.getValue());
                    c++;
                } else {
                    System.out.print(", " + integerStringEntry.getValue());

                }
            }
        }
    }
}
