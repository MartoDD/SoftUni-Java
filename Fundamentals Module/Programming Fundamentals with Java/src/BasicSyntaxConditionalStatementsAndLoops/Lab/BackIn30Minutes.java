package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class BackIn30Minutes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();

        int total = (hours * 60) + minutes + 30;

        int newHours = total / 60;
        int newMinutes = total % 60;

        if (newHours >= 24) {
            newHours -= 24;
        }

        System.out.printf("%d:%02d", newHours, newMinutes);

    }
}
