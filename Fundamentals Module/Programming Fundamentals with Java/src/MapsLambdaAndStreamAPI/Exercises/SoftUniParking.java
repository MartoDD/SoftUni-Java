package MapsLambdaAndStreamAPI.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> users = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            switch (input[0]) {
                case "register":
                    if (users.containsKey(input[1])) {
                        System.out.println("ERROR: already registered with plate number " + users.get(input[1]));
                    } else {
                        users.put(input[1], input[2]);
                        System.out.println(input[1] + " registered " + input[2] + " successfully");
                    }
                    break;
                case "unregister":
                    if (!users.containsKey(input[1])) {
                        System.out.println("ERROR: user " + input[1] + " not found");
                    } else {
                        users.remove(input[1]);
                        System.out.println(input[1] + " unregistered successfully");
                    }
                    break;
            }

        }
        users.forEach((k, v) -> System.out.println(k + " => " + v));

    }
}
