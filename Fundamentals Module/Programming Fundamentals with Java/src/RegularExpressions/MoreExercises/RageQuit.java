package RegularExpressions.MoreExercises;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String componentsRegex = "[^\\d]+\\d+";
        StringBuilder sb = new StringBuilder();
        String symbolsRegex = "[^\\d]";

        Pattern symbolPattern = Pattern.compile(symbolsRegex);
        Pattern pattern = Pattern.compile(componentsRegex);

        Map<String, Integer> symbols = new HashMap<>();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String main = matcher.group(); //we take the text with the symbols and the numbers
            String numberPattern = "\\d+";
            String toBeRepeated = main.split(numberPattern)[0]; // we split the text from the numbers
            Pattern numPattern = Pattern.compile(numberPattern);          //we make a pattern to extract the numbers
            Matcher numberMatcher = numPattern.matcher(matcher.group());
            int repetition = 0;
            while (numberMatcher.find()) {
                repetition = Integer.parseInt(numberMatcher.group()); //number is extracted here
            }
            if (repetition != 0) {                                        //here we check to see if the number is 0 so that we know if we should count the symbols towards the "Unique symbols used"
                Matcher matcher1 = symbolPattern.matcher(toBeRepeated);
                while (matcher1.find()) {
                    String s = matcher1.group().toUpperCase(Locale.ROOT);  //i decided to make a hashmap with keys and int value of 0, so that I can have only unique values with put if absent, at the end I just use the .size
                    symbols.putIfAbsent(s, 0);
                }
            }

            sb.append(toBeRepeated.toUpperCase(Locale.ROOT).repeat(Math.max(0, repetition)));  //we use a string builder to append the text times the number extracted above.
        }
        System.out.println("Unique symbols used: " + symbols.size());
        System.out.println(sb);

    }
}
