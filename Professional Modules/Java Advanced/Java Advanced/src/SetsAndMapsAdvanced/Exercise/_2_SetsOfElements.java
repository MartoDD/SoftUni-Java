package SetsAndMapsAdvanced.Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _2_SetsOfElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] length = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstLength = length[0];
        int secondLength = length[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstLength + secondLength; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            if (i < firstLength) {
                firstSet.add(n);
            } else {
                secondSet.add(n);
            }
        }

        if (firstSet.size() <= secondSet.size()) {
            for (Integer integer : firstSet) {
                if (secondSet.contains(integer)) {
                    System.out.print(integer + " ");
                }
            }

        } else {
            for (Integer integer1 : secondSet) {
                if (firstSet.contains(integer1)) {
                    System.out.println(integer1 + " ");
                }
            }

        }
    }
}
