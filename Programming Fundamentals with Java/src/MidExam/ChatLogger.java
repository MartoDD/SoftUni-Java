package MidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChatLogger {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> chat = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] commands = input.split("\\s+");
            String message;

            switch (commands[0]) {
                case "Chat":
                    message = commands[1];
                    chat.add(message);
                    break;
                case "Delete":
                    message = commands[1];
                    chat.remove(message);
                    break;
                case "Edit":
                    message = commands[1];
                    String messageTwo = commands[2];
                    editCurrentMessageWithNew(chat, message, messageTwo);
                    break;
                case "Pin":
                    message = commands[1];
                    placeGivenMessageAtTheEnd(chat, message);
                    break;
                case "Spam":
                    chat.addAll(Arrays.asList(commands).subList(1, commands.length));
                    break;
            }


            input = scanner.nextLine();
        }
        chat.forEach(System.out::println);
    }

    private static void placeGivenMessageAtTheEnd(List<String> chat, String message) {
        for (int i = 0; i < chat.size(); i++) {
            if (chat.get(i).equals(message)) {
                chat.add(chat.get(i));
                chat.remove(i);
                break;
            }
        }
    }

    private static void editCurrentMessageWithNew(List<String> chat, String message, String messageTwo) {
        for (int i = 0; i < chat.size(); i++) {
            if (chat.get(i).equals(message)) {
                chat.set(i, messageTwo);
            }
        }
    }
}
