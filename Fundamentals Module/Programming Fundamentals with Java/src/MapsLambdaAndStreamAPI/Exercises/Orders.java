package MapsLambdaAndStreamAPI.Exercises;

import java.util.*;

public class Orders {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Double> price = new LinkedHashMap<>();
        Map<String, Integer> quantity = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] data = input.split("\\s+");

            price.put(data[0], Double.parseDouble(data[1]));
            quantity.putIfAbsent(data[0], 0);
            quantity.put(data[0], quantity.get(data[0]) + Integer.parseInt(data[2]));
            input = scanner.nextLine();
        }

        quantity.forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v * price.get(k)));


    }

}
