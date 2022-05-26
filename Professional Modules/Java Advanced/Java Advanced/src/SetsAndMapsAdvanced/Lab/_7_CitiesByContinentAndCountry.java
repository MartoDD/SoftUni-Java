package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class _7_CitiesByContinentAndCountry {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> information = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            information.putIfAbsent(continent, new LinkedHashMap<>());
            information.get(continent).putIfAbsent(country, new ArrayList<>());
            information.get(continent).get(country).add(city);

        }

        for (var entry : information.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (var value : entry.getValue().entrySet()) {
                System.out.print(value.getKey() + " -> ");
                System.out.println(String.join(", ", value.getValue()));


            }

        }

    }
}
