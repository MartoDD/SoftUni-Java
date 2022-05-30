package SetsAndMapsAdvanced.Exercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class _10_LogsAggregator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> userTime = new TreeMap<>();
        Map<String, Set<String>> userIp = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");

            String ip = input[0];
            String user = input[1];
            int time = Integer.parseInt(input[2]);

            userTime.putIfAbsent(user, 0);
            userTime.put(user, userTime.get(user) + time);
            userIp.putIfAbsent(user, new TreeSet<>());
            userIp.get(user).add(ip);

        }

        userTime.forEach((key, value) -> {
            System.out.printf("%s: %d [", key, value);
            AtomicInteger count = new AtomicInteger();
            userIp.get(key).forEach(u -> {
                if (count.get() == 0) {
                    System.out.print(u);
                    count.getAndIncrement();
                } else {
                    System.out.print(", " + u);
                }
            });
            System.out.println("]");
        });
    }
}
