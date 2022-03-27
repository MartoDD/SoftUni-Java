package MapsLambdaAndStreamAPI.Exercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ForceBook {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AtomicBoolean hasUser = new AtomicBoolean(false);

        Map<String, List<String>> forceUsers = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Lumpawaroo")) {


            if (input.contains("|")) {
                String[] data = input.split(" \\| ");
                forceUsers.putIfAbsent(data[0], new ArrayList<>());
                forceUsers.forEach((k, v) -> {
                    if (v.contains(data[1])) {
                        hasUser.set(true);
                    }
                });
                if (!hasUser.get()) {
                    forceUsers.get(data[0]).add(data[1]);
                } else {
                    hasUser.set(false);
                }

            } else if (input.contains("->")) {
                String[] data = input.split(" -> ");
                forceUsers.putIfAbsent(data[1], new ArrayList<>());
                forceUsers.forEach((k, v) -> {
                    if (v.contains(data[0]) && !hasUser.get()) {
                        v.remove(data[0]);
                        forceUsers.get(data[1]).add(data[0]);
                        System.out.println(data[0] + " joins the " + data[1] + " side!");
                        hasUser.set(true);

                    }
                });
                if (!hasUser.get()) {
                    forceUsers.get(data[1]).add(data[0]);
                    System.out.println(data[0] + " joins the " + data[1] + " side!");

                } else {
                    hasUser.set(false);
                }

            }

            input = scanner.nextLine();
        }

        forceUsers.forEach((k, v) -> {
            if (v.size() != 0) {
                System.out.println("Side: " + k + ", Members: " + v.size());
                v.forEach(s -> System.out.println("! " + s));
            }

        });


    }
}
