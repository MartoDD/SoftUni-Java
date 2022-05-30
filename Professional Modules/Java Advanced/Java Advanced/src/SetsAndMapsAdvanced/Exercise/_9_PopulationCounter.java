package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _9_PopulationCounter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        Map<String, Long> countries = new LinkedHashMap<>();

        while (!input.equals("report")) {

            String[] information = input.split("\\|");

            String city = information[0];
            String country = information[1];
            int cityPopulation = Integer.parseInt(information[2]);

            map.putIfAbsent(country, new LinkedHashMap<>());
            map.get(country).putIfAbsent(city, cityPopulation);
            countries.putIfAbsent(country, 0L);
            countries.put(country, countries.get(country) + cityPopulation);

            input = scanner.nextLine();
        }
        map.entrySet().stream()
                .sorted((c1, c2) -> countries.get(c2.getKey()).compareTo(countries.get(c1.getKey())))
                .forEach(country -> {
                    System.out.println(country.getKey() + " (total population: " + countries.get(country.getKey()) + ")");
                    country.getValue().entrySet()
                            .stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue())).forEach(city -> System.out.println("=>" + city.getKey() + ": " + city.getValue()));
                });

    }
}
