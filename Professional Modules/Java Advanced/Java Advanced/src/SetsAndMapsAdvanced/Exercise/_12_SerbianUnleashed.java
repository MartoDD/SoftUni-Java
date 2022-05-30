package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_SerbianUnleashed {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regEx = "(?<name>[\\w\\s*]+)\\s@(?<venue>[\\w\\s*]+)\\s(?<ticketPrice>\\d+)\\s(?<ticketCount>\\d+)";

        Map<String, Map<String, Integer>> prices = new LinkedHashMap<>();

        while (!input.equals("End")) {
            if (input.matches(regEx)) {
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(input);
                if (matcher.find()) {
                    String name = matcher.group("name");
                    String venue = matcher.group("venue");
                    int ticketPrice = Integer.parseInt(matcher.group("ticketPrice"));
                    int ticketCount = Integer.parseInt(matcher.group("ticketCount"));
                    int totalPrice = ticketPrice * ticketCount;

                    prices.putIfAbsent(venue, new LinkedHashMap<>());
                    prices.get(venue).putIfAbsent(name, 0);
                    prices.get(venue).put(name, prices.get(venue).get(name) + totalPrice);
                }
            }

            input = scanner.nextLine();
        }

        prices.forEach((k, v) -> {
            System.out.println(k);
            v.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(stringIntegerEntry -> System.out.println("#  " + stringIntegerEntry.getKey() + " -> " + stringIntegerEntry.getValue()));
        });
    }
}
