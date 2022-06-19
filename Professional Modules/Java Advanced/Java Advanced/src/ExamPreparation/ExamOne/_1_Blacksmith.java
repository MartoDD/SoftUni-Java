package ExamPreparation.ExamOne;

import java.util.*;
import java.util.stream.Collectors;

public class _1_Blacksmith {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steel = new ArrayDeque<>();
        ArrayDeque<Integer> carbon = new ArrayDeque<>();
        Map<String, Integer> swords = new TreeMap<>();
        int swordCount = 0;

        List<Integer> steelInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> carbonInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        steelInput.forEach(steel::offer);
        carbonInput.forEach(carbon::push);

        while (carbon.size() > 0 && steel.size() > 0) {
            int steelValue = steel.poll();
            int carbonValue = carbon.pop();
            int totalValue = steelValue + carbonValue;

            if (!checkValue(totalValue, swords)) {
                carbonValue += 5;
                carbon.push(carbonValue);
            } else {
                swordCount++;
            }

        }
        if (swordCount > 0) {
            System.out.printf("You have forged %d swords.%n", swordCount);

        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }


        if (steel.size() > 0) {
            System.out.println("Steel left: " + steel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("Steel left: none");
        }
        if (carbon.size() > 0) {
            System.out.println("Carbon left: " + carbon.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("Carbon left: none");
        }


        swords.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private static boolean checkValue(int totalValue, Map<String, Integer> swords) {
        String sword;
        switch (totalValue) {
            case 70:
                sword = "Gladius";
                swords.putIfAbsent(sword, 0);
                swords.put(sword, swords.get(sword) + 1);

                return true;
            case 80:
                sword = "Shamshir";
                swords.putIfAbsent(sword, 0);
                swords.put(sword, swords.get(sword) + 1);
                return true;
            case 90:
                sword = "Katana";
                swords.putIfAbsent(sword, 0);
                swords.put(sword, swords.get(sword) + 1);
                return true;
            case 110:
                sword = "Sabre";
                swords.putIfAbsent(sword, 0);
                swords.put(sword, swords.get(sword) + 1);
                return true;

        }
        return false;
    }
}
