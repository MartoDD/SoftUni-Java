package Lists.MoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        StringBuilder input = new StringBuilder(scanner.nextLine());
        StringBuilder out = new StringBuilder();

        for (int number : numbers) {
            int sum = 0;
            while (number > 0) {

                int digit = number % 10;
                number /= 10;
                sum += digit;
            }
            int count = 0;
            for (int j = 0; j < sum; j++) {
                if (count < input.length()) {
                    count++;
                } else {
                    count = 1;
                }
            }
            out.append(input.charAt(count));
            input.deleteCharAt(count);


        }
        System.out.println(out);
    }
}
