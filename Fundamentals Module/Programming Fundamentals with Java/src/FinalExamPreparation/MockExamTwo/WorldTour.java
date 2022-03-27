package FinalExamPreparation.MockExamTwo;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());


        String command = scanner.nextLine();

        while (!command.equals("Travel")) {
            String[] data = command.split(":");
            String instruction = data[0];
            switch (instruction) {
                case "Add Stop":
                    int index = Integer.parseInt(data[1]);
                    if (index >= 0 && index < stops.length()) {
                        String string = data[2];
                        stops.insert(index, string);
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(data[1]);
                    int endIndex = Integer.parseInt(data[2]);
                    if (startIndex >= 0 && startIndex < stops.length() && endIndex >= 0 && endIndex < stops.length()) {
                        stops.replace(startIndex, endIndex + 1, "");
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString = data[1];
                    String newString = data[2];
                    int i = stops.indexOf(oldString);
                    if (i >= 0 && i < stops.length() && i + oldString.length() < stops.length()) {
                        stops.replace(i, i + oldString.length(), newString);
                    }
                    System.out.println(stops);
                    break;
            }


            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }
}
