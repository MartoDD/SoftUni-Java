package Lists.Excersise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int capacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] commands = input.split(" ");
            if (commands[0].equals("Add")) {
                int values = Integer.parseInt(commands[1]);
                wagons.add(values);
            } else {
                int v = Integer.parseInt(input);
                for (int i = 0; i < wagons.size(); i++) {
                    if ((wagons.get(i) + v) <= capacity) {
                        wagons.set(i, wagons.get(i) + v);
                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }
        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }

    }
}
