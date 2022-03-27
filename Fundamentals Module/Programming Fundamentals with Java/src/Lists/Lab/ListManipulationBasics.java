package Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] command = input.split(" ");

            switch (command[0]) {
                case "Add":
                    int value = Integer.parseInt(command[1]);
                    numbers.add(value);
                    break;
                case "Remove":
                    int v = Integer.parseInt(command[1]);
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i).equals(v)) {
                            numbers.remove(i);
                        }
                    }
                    break;
                case "RemoveAt":
                    int va = Integer.parseInt(command[1]);
                    numbers.remove(va);
                    break;
                case "Insert":
                    int val = Integer.parseInt(command[1]);
                    int index = Integer.parseInt(command[2]);
                    numbers.add(index, val);
                    break;

            }


            input = scanner.nextLine();
        }

        for (Integer i : numbers) {
            System.out.print(i + " ");
        }
    }
}
