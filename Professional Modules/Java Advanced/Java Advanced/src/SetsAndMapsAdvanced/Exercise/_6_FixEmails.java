package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _6_FixEmails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> people = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String email = scanner.nextLine();

            String[] toCheck = email.split("\\.");
            if (!toCheck[toCheck.length - 1].equals("us") && !toCheck[toCheck.length - 1].equals("uk") && !toCheck[toCheck.length - 1].equals("com")) {
                people.putIfAbsent(input, "");
                people.put(input, email);
            }
            input = scanner.nextLine();
        }
        for (var entry : people.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }

    }
}
