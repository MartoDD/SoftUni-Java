package FinalExamPreparation.MockExamOne;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, String>> songs = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\|");
            String piece = data[0];
            String composer = data[1];
            String key = data[2];
            songs.put(piece, new LinkedHashMap<>());
            songs.get(piece).put(composer, key);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] data = input.split("\\|");
            String command = data[0];

            switch (command) {
                case "Add":
                    String piece = data[1];
                    String composer = data[2];
                    String key = data[3];
                    if (songs.containsKey(piece)) {
                        System.out.println(piece + " is already in the collection!");
                    } else {
                        songs.put(piece, new LinkedHashMap<>());
                        songs.get(piece).put(composer, key);
                        System.out.println(piece + " by " + composer + " in " + key + " added to the collection!");
                    }
                    break;
                case "Remove":
                    String toBeRemoved = data[1];
                    if (songs.containsKey(toBeRemoved)) {
                        songs.remove(toBeRemoved);
                        System.out.println("Successfully removed " + toBeRemoved + "!");
                    } else {
                        System.out.println("Invalid operation! " + toBeRemoved + " does not exist in the collection.");
                    }
                    break;
                case "ChangeKey":
                    String p = data[1];
                    String newKey = data[2];

                    if (songs.containsKey(p)) {
                        songs.get(p).entrySet().forEach(stringStringEntry -> stringStringEntry.setValue(newKey));
                        System.out.println("Changed the key of " + p + " to " + newKey + "!");
                    } else {
                        System.out.println("Invalid operation! " + p + " does not exist in the collection.");
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        songs.forEach((k, v) -> {
            v.forEach((key, value) -> System.out.printf("%s -> Composer: %s, Key: %s%n", k, key, value));
        });
    }
}
