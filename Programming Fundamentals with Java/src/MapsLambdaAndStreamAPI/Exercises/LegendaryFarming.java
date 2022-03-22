package MapsLambdaAndStreamAPI.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> materials = new LinkedHashMap<>();


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
                    materials.putIfAbsent(material, 0);
                    materials.put(material, materials.get(material) + quantity);
                    if (materials.containsKey("shards") && materials.get("shards") >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        materials.put("shards", materials.get("shards") - 250);
                        materials.forEach((k, v) -> System.out.println(k + ": " + v));
                        hasLegendary = true;
                        break;
                    } else if (materials.containsKey("fragments") && materials.get("fragments") >= 250) {
                        System.out.println("Valanyr obtained!");
                        materials.put("fragments", materials.get("fragments") - 250);
                        materials.forEach((k, v) -> System.out.println(k + ": " + v));
                        hasLegendary = true;
                        break;
                    } else if (materials.containsKey("motes") && materials.get("motes") >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        materials.put("motes", materials.get("motes") - 250);
                        materials.forEach((k, v) -> System.out.println(k + ": " + v));
                        hasLegendary = true;
                        break;
                    }
                }

            }

        }


    }
}
