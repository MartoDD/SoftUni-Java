package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class _8_UserLogs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> players = new TreeMap<>();

        while (!input.equals("end")) {

            String[] data = input.split("[=\\s]");
            String username = data[data.length - 1];
            String ip = data[1];

            players.putIfAbsent(username, new LinkedHashMap<>());
            players.get(username).putIfAbsent(ip, 0);
            players.get(username).put(ip, players.get(username).get(ip) + 1);


            input = scanner.nextLine();
        }

        for (var entry : players.entrySet()) {
            System.out.println(entry.getKey() + ":");
            AtomicInteger count = new AtomicInteger();
            entry.getValue().forEach((key, value) -> {
                if (count.get() == 0) {
                    System.out.print(key + " => " + value);
                    count.getAndIncrement();
                } else {
                    System.out.print(", " + key + " => " + value);
                }
            });
            System.out.print(".");
            System.out.println();
        }

    }
}
