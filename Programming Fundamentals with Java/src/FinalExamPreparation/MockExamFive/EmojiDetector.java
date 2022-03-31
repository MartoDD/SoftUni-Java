package FinalExamPreparation.MockExamFive;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String numbers = "\\d";
        long coolTreshold = 1;
        Pattern pattern = Pattern.compile(numbers);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            coolTreshold *= Integer.parseInt(matcher.group());
        }

        String regEx = "(:{2}|\\*{2})(?<check>[A-Z][a-z]{2,})\\1";
        Pattern patternEmoji = Pattern.compile(regEx);
        Matcher matcherEmoji = patternEmoji.matcher(input);
        int coolEmojies = 0;
        List<String> forOutput = new ArrayList<>();
        while (matcherEmoji.find()) {
            coolEmojies++;
            String toCheck = matcherEmoji.group("check");
            int sum = 0;
            for (int i = 0; i < toCheck.length(); i++) {
                sum += toCheck.charAt(i);
            }
            if (sum >= coolTreshold) {
                forOutput.add(matcherEmoji.group());
            }

        }
        System.out.println("Cool threshold: " + coolTreshold);
        System.out.println(coolEmojies + " emojis found in the text. The cool ones are: ");
        for (String s : forOutput) {
            System.out.println(s);
        }


    }
}
