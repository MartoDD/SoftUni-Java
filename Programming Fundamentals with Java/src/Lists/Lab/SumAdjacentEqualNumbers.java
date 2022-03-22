package Lists.Lab;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        List<Double> summedNumbers = sumTheNumbers(numbers);

        while (summedNumbers.size() != numbers.size()) {
            numbers = summedNumbers;
            summedNumbers = sumTheNumbers(numbers);
        }


        for (Double d : summedNumbers) {
            System.out.print(new DecimalFormat("0.#").format(d) + " ");
        }
    }

    private static List<Double> sumTheNumbers(List<Double> numbers) {
        List<Double> summedNumbers = new ArrayList<>();
        int index = 0;
        while (index < numbers.size()) {

            if (index < numbers.size() - 1 && numbers.get(index).equals(numbers.get(index + 1))) {
                summedNumbers.add(numbers.get(index) + numbers.get(index + 1));
                index += 2;
            } else {
                summedNumbers.add(numbers.get(index));
                index++;
            }
        }
        return summedNumbers;
    }
}
