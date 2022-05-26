package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _4_CountRealNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> map = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(aDouble -> {
            map.putIfAbsent(aDouble, 0);
            map.put(aDouble, map.get(aDouble) + 1);
        });

        for (var entry : map.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
