package RegularExpressions.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("[,\\s+]+")).collect(Collectors.toList());
        Pattern namePattern = Pattern.compile("[^0-9+\\-*\\/.]");
        for (String s : input) {
            Matcher nameMatcher = namePattern.matcher(s);
            StringBuilder sb = new StringBuilder();
            while (nameMatcher.find()) {
                sb.append(nameMatcher.group());
            }
            String name = sb.toString();
            int health = 0;
            double damage = 0;
            for (int j = 0; j < name.length(); j++) {
                int value = name.charAt(j);
                health += value;
            }
            Pattern numberPattern = Pattern.compile("(?:\\+|-)?[0-9]+(?:\\.[0-9]+)?");
            Matcher numberMatcher = numberPattern.matcher(s);
            while (numberMatcher.find()) {
                damage += Double.parseDouble(numberMatcher.group());
            }
            Pattern specialPattern = Pattern.compile("[*\\/]");
            Matcher specialMatcher = specialPattern.matcher(s);
            StringBuilder specialBuilder = new StringBuilder();
            while (specialMatcher.find()) {
                specialBuilder.append(specialMatcher.group());
            }
            String symbols = specialBuilder.toString();
            for (int i = 0; i < symbols.length(); i++) {
                switch (symbols.charAt(i)) {
                    case '*':
                        damage *= 2;
                        break;
                    case '/':
                        damage /= 2;
                        break;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n",s,health,damage);

        }


    }
}
