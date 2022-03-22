package RegularExpressions.Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b(?<day>\\d{2})(.)(?<month>[Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec]+)\\2(?<year>\\d{4})\\b");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("Day: " + matcher.group("day") + ", Month: " + matcher.group("month") + ", Year: " + matcher.group("year"));
        }
    }
}
