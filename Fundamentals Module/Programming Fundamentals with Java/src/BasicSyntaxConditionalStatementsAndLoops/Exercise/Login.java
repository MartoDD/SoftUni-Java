package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class Login {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        StringBuilder password = new StringBuilder();

        int counter = 0;
        boolean locked = false;

        for (int i = username.length() - 1; i >= 0; i--) {
            password.append(username.charAt(i));
        }
        String input = scanner.nextLine();

        while (!input.equals(password.toString())) {

            if (counter == 3) {
                System.out.printf("User %s blocked!", username);
                locked = true;
                break;
            }

            System.out.println("Incorrect password. Try again.");
            counter++;
            input = scanner.nextLine();
        }
        if (!locked) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
