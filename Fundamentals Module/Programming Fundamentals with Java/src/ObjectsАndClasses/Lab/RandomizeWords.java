package ObjectsАndClasses.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> input = new java.util.ArrayList<>(Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toUnmodifiableList()));

        Random rnd = new Random();

        for (int i = 0; i < input.size(); i++) {
            int number = rnd.nextInt(input.size());
            String temp = input.get(i);
            input.set(i, input.get(number));
            input.set(number, temp);
        }

        for (String s : input) {
            System.out.println(s);
        }
    }
}
