package Lists.Excersise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> detonator = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int bomb = detonator.get(0);
        int size = detonator.get(1);
        int i = 0;
        while (i < numbers.size()) {
            if (numbers.get(i) == bomb) {
                int additional = 0;
                int index;
                if (i - size >= 0) {
                    index = i - size;
                } else {
                    index = 0;
                    additional = i - size;
                }
                int totalBlown = (size * 2 + 1) - Math.abs(additional);
                for (int j = 0; j < totalBlown; j++) {
                    if (index < numbers.size()) {
                        numbers.remove(index);
                    }
                }
            } else {
                i++;
            }
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);


    }
}
