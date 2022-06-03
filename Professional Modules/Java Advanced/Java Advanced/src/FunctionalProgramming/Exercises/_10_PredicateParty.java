package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_PredicateParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {

            String[] commands = input.split("\\s+");
            Predicate<String> predicate = getPredicate(commands[1], commands[2]);

            switch (commands[0]) {
                case "Double":
                    List<String> temp = new ArrayList<>();
                    guests.stream().filter(predicate).forEach(temp::add);
                    guests.addAll(temp);
                    break;
                case "Remove":
                    guests.removeIf(predicate);
                    break;
            }
            input = scanner.nextLine();
        }

        if (guests.size() != 0) {
            System.out.print(guests.stream().sorted().collect(Collectors.joining(", ")));
            System.out.println(" are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }

    }

    private static Predicate<String> getPredicate(String command, String command1) {
        switch (command) {
            case "StartsWith":
                return s -> s.startsWith(command1);
            case "EndsWith":
                return s -> s.endsWith(command1);
            case "Length":
                return s -> s.length() == Integer.parseInt(command1);
            default:
                throw new IllegalStateException();
        }
    }

}
