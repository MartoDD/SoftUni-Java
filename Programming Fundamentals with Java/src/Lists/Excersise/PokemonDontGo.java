package Lists.Excersise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;

        while (numbers.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {
                for (int i = 1; i < numbers.size(); i++) {
                    if (numbers.get(0) >= numbers.get(i)) {
                        numbers.set(i, numbers.get(i) + numbers.get(0));
                    } else {
                        numbers.set(i, numbers.get(i) - numbers.get(0));
                    }
                }
                sum += numbers.get(0);
                numbers.set(0, numbers.get(numbers.size() - 1));

            } else if (index >= numbers.size()) {
                for (int i = numbers.size() - 2; i >= 0; i--) {
                    if (numbers.get(numbers.size() - 1) >= numbers.get(i)) {
                        numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
                    } else {
                        numbers.set(i, numbers.get(i) - numbers.get(numbers.size() - 1));
                    }
                }
                sum += numbers.get(numbers.size() - 1);
                numbers.set(numbers.size() - 1, numbers.get(0));

            } else {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(index) >= numbers.get(i) && index != i) {
                        numbers.set(i, numbers.get(index) + numbers.get(i));
                    } else if (numbers.get(index) < numbers.get(i) && index != i) {
                        numbers.set(i, numbers.get(i) - numbers.get(index));
                    }
                }
                sum += numbers.get(index);
                numbers.remove(index);

            }

        }
        System.out.println(sum);
    }
}
