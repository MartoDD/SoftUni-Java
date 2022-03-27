package MapsLambdaAndStreamAPI.MoreExercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Ranking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, String> contestPassword = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end of contests")) {
            String[] data = input.split(":");
            contestPassword.put(data[0], data[1]);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        Map<String, Map<String, Integer>> contestantResult = new TreeMap<>();
        while (!input.equals("end of submissions")) {
            String[] data = input.split("=>");

            if (contestPassword.containsKey(data[0]) && contestPassword.get(data[0]).equals(data[1])) {
                contestantResult.putIfAbsent(data[2], new TreeMap<>());
                contestantResult.get(data[2]).putIfAbsent(data[0], 0);
                if (contestantResult.get(data[2]).get(data[0]) < Integer.parseInt(data[3])) {
                    contestantResult.get(data[2]).put(data[0], Integer.parseInt(data[3]));
                }
            }

            input = scanner.nextLine();

        }
        AtomicReference<String> best = new AtomicReference<>("");
        AtomicInteger top = new AtomicInteger();

        contestantResult.forEach((k, v) -> {
            AtomicInteger sum = new AtomicInteger();
            v.forEach((kl, s) -> sum.addAndGet(s));
            if (sum.get() > top.get()) {
                top.set(sum.get());
                best.set(k);
            }
        });
        System.out.println("Best candidate is " + best + " with total " + top + " points.");
        System.out.println("Ranking: ");

        contestantResult.forEach((k, v) -> {
            System.out.println(k);
            Map<Integer, String> hehe = new TreeMap<>(Collections.reverseOrder());
            v.forEach((kl, s) -> hehe.put(s, kl));

            hehe.forEach((a, b) -> System.out.println("#  " + b + " -> " + a));

        });
    }
}
