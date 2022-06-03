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


            Predicate<String> startsWith = s -> !s.startsWith(parameter);
            Predicate<String> endsWith = s -> !s.endsWith(parameter);
            Predicate<String> length = s -> s.length() != Integer.parseInt(parameter);
            Predicate<String> contains = s -> !s.contains(parameter);

            switch (direction) {
                case "Starts with":
                    guests = guests.stream().filter(startsWith).collect(Collectors.toList());
                    break;
                case "Ends with":
                    guests = guests.stream().filter(endsWith).collect(Collectors.toList());
                    break;
                case "Length":
                    guests = guests.stream().filter(length).collect(Collectors.toList());
                    break;
                case "Contains":
                    guests = guests.stream().filter(contains).collect(Collectors.toList());
                    break;
            }
        }
        System.out.println(String.join(" ", guests));


    }
}
