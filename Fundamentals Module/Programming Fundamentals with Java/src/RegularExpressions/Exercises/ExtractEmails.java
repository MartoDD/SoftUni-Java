package RegularExpressions.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regEx = "(?<=\\s)[a-zA-Z0-9]+([-.]\\w+)*@[a-zA-Z]+([.-][a-zA-Z]*)*(\\.[a-z]{2,})";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
