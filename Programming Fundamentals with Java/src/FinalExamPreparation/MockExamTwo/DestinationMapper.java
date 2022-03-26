package FinalExamPreparation.MockExamTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String regEx = "([=\\/])(?<name>[A-Z][A-Za-z]{2,})\\1";

        List<String> destinations = new ArrayList<>();

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);
        int sum = 0;
        while (matcher.find()) {
            String name = matcher.group("name");
            sum += name.length();
            destinations.add(name);
        }
        System.out.print("Destinations: ");
        for (int i = 0; i < destinations.size(); i++) {
            if (i == 0) {
                System.out.print(destinations.get(i));
            } else {
                System.out.print(", " + destinations.get(i));
            }
        }
        System.out.println();
        System.out.println("Travel Points: " + sum);

    }
}
