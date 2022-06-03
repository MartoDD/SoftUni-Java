package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11_ThePartyReservationFilterModule {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> commandLines = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Print")) {
            String[] commands = input.split(";");

            switch (commands[0]) {
                case "Add filter":
                    commandLines.add(commands[1] + ";" + commands[2]);
                    break;
                case "Remove filter":
                    commandLines.removeIf(s -> s.endsWith(commands[2]));
                    break;
            }

            input = scanner.nextLine();
        }

        for (String commandLine : commandLines) {
            String[] miniCommands = commandLine.split(";");
            String direction = miniCommands[0];
            String parameter = miniCommands[1];

            Predicate<String> predicate = getPredicate(direction, parameter);

            guests = guests.stream().filter(predicate).collect(Collectors.toList());

        }
        System.out.println(String.join(" ", guests));


    }

    private static Predicate<String> getPredicate(String direction, String parameter) {
        switch (direction) {
            case "Starts with":
                return s -> !s.startsWith(parameter);
            case "Ends with":
                return s -> !s.endsWith(parameter);
            case "Length":
                return s -> s.length() != Integer.parseInt(parameter);
            case "Contains":
                return s -> !s.contains(parameter);
            default:
                throw new IllegalStateException();
        }
    }
}
