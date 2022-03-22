package MidExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> tagetsCopy = new ArrayList<>(targets);
        String input = scanner.nextLine();
        int shotTargets = 0;
        while (!input.equals("End")) {
            int value = Integer.parseInt(input);

            if ((value < tagetsCopy.size()) && (tagetsCopy.get(value) != -1)) {
                tagetsCopy.set(value, -1);
                shotTargets++;
                for (int i = 0; i < tagetsCopy.size(); i++) {
                    if ((i != value) && (tagetsCopy.get(i) != -1)) {
                        if (tagetsCopy.get(i) <= targets.get(value)) {
                            tagetsCopy.set(i, tagetsCopy.get(i) + targets.get(value));
                        } else if (tagetsCopy.get(i) > targets.get(value)) {
                            tagetsCopy.set(i, tagetsCopy.get(i) - targets.get(value));
                        }
                    }
                }
            }
            for (int i = 0; i < tagetsCopy.size(); i++) {
                targets.set(i, tagetsCopy.get(i));
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", shotTargets);
        for (Integer integer : tagetsCopy) {
            System.out.print(integer + " ");
        }

    }
}
