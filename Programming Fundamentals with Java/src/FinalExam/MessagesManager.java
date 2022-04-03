package FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MessagesManager {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        Map<String, User> users = new LinkedHashMap<>();
        while (!input.equals("Statistics")) {
            String[] commands = input.split("=");

            switch (commands[0]) {
                case "Add":
                    String username = commands[1];
                    int sent = Integer.parseInt(commands[2]);
                    int received = Integer.parseInt(commands[3]);
                    users.putIfAbsent(username, new User(username, sent, received));
                    break;
                case "Message":
                    String sender = commands[1];
                    String receiver = commands[2];
                    if (users.containsKey(sender) && users.containsKey(receiver)) {
                        if (users.get(sender).getSent() + users.get(sender).getReceived() + 1 >= capacity) {
                            users.remove(sender);
                            System.out.println(sender + " reached the capacity!");
                        } else {
                            users.get(sender).setSent(users.get(sender).getSent() + 1);
                        }
                        if (users.get(receiver).getSent() + users.get(receiver).getReceived() + 1 >= capacity) {
                            users.remove(receiver);
                            System.out.println(receiver + " reached the capacity!");
                        } else {
                            users.get(receiver).setReceived(users.get(receiver).getReceived() + 1);
                        }
                    }
                    break;
                case "Empty":
                    String name = commands[1];
                    if (!name.equals("All")) {
                        users.remove(name);
                    } else {
                        users = new LinkedHashMap<>();
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Users count: " + users.size());
        users.forEach((k, v) -> System.out.printf("%s - %d%n", v.getUsername(), v.getReceived() + v.getSent()));
    }

    static class User {
        String username;
        int sent;
        int received;

        public User(String username, int sent, int received) {
            this.username = username;
            this.sent = sent;
            this.received = received;
        }

        public String getUsername() {
            return username;
        }

        public int getSent() {
            return sent;
        }

        public void setSent(int sent) {
            this.sent = sent;
        }

        public int getReceived() {
            return received;
        }

        public void setReceived(int received) {
            this.received = received;
        }
    }
}
