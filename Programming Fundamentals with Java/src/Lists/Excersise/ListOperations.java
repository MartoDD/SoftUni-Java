package Lists.Excersise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "Add":
                    int v = Integer.parseInt(commands[1]);
                    numbers.add(v);
                    break;
                case "Insert":
                    int va = Integer.parseInt(commands[1]);
                    int index = Integer.parseInt(commands[2]);
                    if (index < numbers.size() && index >= 0) {
                        numbers.add(index, va);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int ind = Integer.parseInt(commands[1]);
                    if (ind < numbers.size() && ind >= 0) {
                        numbers.remove(ind);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":

                    if (commands[1].equals("left")) {

                        int val = Integer.parseInt(commands[2]);
                        for (int i = 0; i < val; i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }

                    } else if (commands[1].equals("right")) {
                        int val = Integer.parseInt(commands[2]);

                        for (int i = 0; i < val; i++) {

                            numbers.add(0, numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }


            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}
