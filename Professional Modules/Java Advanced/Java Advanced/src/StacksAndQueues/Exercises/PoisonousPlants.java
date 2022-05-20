package StacksAndQueues.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> numberQueue = new ArrayDeque<>();

        for (int i = numbers.size() - 1; i >= 0; i--) {
            numberQueue.offer(numbers.get(i));
        }

        boolean allSurvived = false;
        int days = 0;
        while (!allSurvived) {
            allSurvived = true;
            for (int i = 0; i < n; i++) {
                int current = numberQueue.poll();
                if (i == n - 1) {
                    numberQueue.offer(current);
                } else {
                    if (current <= numberQueue.peek()) {
                        numberQueue.offer(current);
                    } else {
                        allSurvived = false;
                    }
                }
            }
            if (!allSurvived) {
                days++;
            }
            n = numberQueue.size();
        }
        System.out.println(days);
    }
}
