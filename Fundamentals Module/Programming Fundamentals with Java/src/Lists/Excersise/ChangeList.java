package Lists.Excersise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] command = input.split(" ");

            if (command[0].equals("Delete")) {

                int value = Integer.parseInt(command[1]);
                numbers.removeAll(Collections.singleton(value));

            } else if (command[0].equals("Insert")) {

                int element = Integer.parseInt(command[1]);
                int position = Integer.parseInt(command[2]);
                numbers.add(position, element);
            }


            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}
