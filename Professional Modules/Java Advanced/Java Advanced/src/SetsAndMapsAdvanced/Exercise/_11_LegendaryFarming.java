package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _11_LegendaryFarming {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> materials = new TreeMap<>();
        Map<String, Integer> junk = new TreeMap<>();


        boolean hasLegendary = false;
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        String material;
        int quantity = 0;

        while (!hasLegendary) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i++) {
                if (i % 2 == 0) {
                    quantity = Integer.parseInt(input[i]);
                } else {
                    material = input[i].toLowerCase();
                    if (material.equals("shards") || material.equals("motes") || material.equals("fragments")) {
                        materials.put(material, materials.get(material) + quantity);
                    } else {
                        junk.putIfAbsent(material, 0);
                        junk.put(material, junk.get(material) + quantity);
                    }

                    if (materials.containsKey("shards") && materials.get("shards") >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        printResult(materials, "shards");
                        junk.forEach((k, v) -> System.out.println(k + ": " + v));
                        hasLegendary = true;
                        break;
                    } else if (materials.containsKey("fragments") && materials.get("fragments") >= 250) {
                        System.out.println("Valanyr obtained!");
                        printResult(materials, "fragments");
                        junk.forEach((k, v) -> System.out.println(k + ": " + v));
                        hasLegendary = true;
                        break;
                    } else if (materials.containsKey("motes") && materials.get("motes") >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        printResult(materials, "motes");
                        junk.forEach((k, v) -> System.out.println(k + ": " + v));
                        hasLegendary = true;
                        break;
                    }
                }

            }

        }

    }

    private static void printResult(Map<String, Integer> materials, String shards) {
        materials.put(shards, materials.get(shards) - 250);
        materials.entrySet().stream()
                .sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue()))
                .forEach((k) -> System.out.println(k.getKey() + ": " + k.getValue()));
    }
}
