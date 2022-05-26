package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _6_ProductShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Double>> information = new TreeMap<>();
        while (!input.equals("Revision")) {

            String[] data = input.split(", ");
            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            information.putIfAbsent(shop, new LinkedHashMap<>());
            information.get(shop).putIfAbsent(product, price);

            input = scanner.nextLine();
        }

        for (var entry : information.entrySet()) {
            System.out.println(entry.getKey() + "->");
            for (var value : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", value.getKey(), value.getValue());
            }

        }

    }
}
