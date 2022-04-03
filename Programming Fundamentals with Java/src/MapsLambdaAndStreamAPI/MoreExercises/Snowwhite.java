package MapsLambdaAndStreamAPI.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> dwarves = new LinkedHashMap<>();

        while (!input.equals("Once upon a time")) {
            String[] data = input.split(" <:> ");
            String name = data[0];
            String color = data[1];
            int physics = Integer.parseInt(data[2]);

            if (dwarves.containsKey(color) && dwarves.get(color).containsKey(name)) {
                if (dwarves.get(color).get(name) < physics) {
                    dwarves.get(color).put(name, physics);
                }
            } else if (dwarves.containsKey(color) && !dwarves.get(color).containsKey(name)) {
                dwarves.get(color).put(name, physics);
            } else {
                dwarves.putIfAbsent(color, new LinkedHashMap<>());
                dwarves.get(color).putIfAbsent(name, physics);
            }


            input = scanner.nextLine();
        }

        Map<String, Integer> print = new LinkedHashMap<>();

        for(Map.Entry<String, LinkedHashMap<String, Integer>> entry : dwarves.entrySet()) {
            for(Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                print.put(entry.getKey() + " " + subEntry.getKey() + " " + entry.getValue().size(), subEntry.getValue());
            }
        }
        print.entrySet().stream().sorted((pair2, pair1) -> {
            int sort = Integer.compare(pair1.getValue(), pair2.getValue());
            if (sort == 0) {
                String[] sort1 = pair1.getKey().split(" ");
                String[] sort2 = pair2.getKey().split(" ");
                sort = sort1[2].compareTo(sort2[2]);
            }
            return sort;
        }).forEach(pair -> {
            String[] printing = pair.getKey().split(" ");
            System.out.printf("(%s) %s <-> %d\n", printing[0], printing[1], pair.getValue());
        });
    }
}
