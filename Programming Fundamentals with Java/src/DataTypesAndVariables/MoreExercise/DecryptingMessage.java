package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class DecryptingMessage {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char in = scanner.nextLine().charAt(0);
            in += key;
            output.append(in);
        }
        System.out.println(output);
    }
}
