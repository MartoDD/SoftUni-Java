package SetsAndMapsAdvanced.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _5_Phonebook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {

            String[] information = input.split("-");
            String name = information[0];
            String number = information[1];

            phonebook.putIfAbsent(name, "");
            phonebook.put(name, number);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("stop")) {
            String name = input;

            if (phonebook.containsKey(name)) {
                System.out.println(name + " -> " + phonebook.get(name));
            } else {
                System.out.println("Contact " + name + " does not exist.");
            }


            input = scanner.nextLine();
        }
    }
}
