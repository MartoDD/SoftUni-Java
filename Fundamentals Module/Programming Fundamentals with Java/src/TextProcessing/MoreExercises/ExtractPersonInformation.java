package TextProcessing.MoreExercises;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            int firstIndex = input.indexOf("@");
            int secondIndex = input.indexOf("|");
            String name = input.substring(firstIndex + 1, secondIndex);
            firstIndex = input.indexOf("#");
            secondIndex = input.indexOf("*");
            String age = input.substring(firstIndex + 1, secondIndex);

            System.out.println(name + " is " + age + " years old.");
        }
    }
}
