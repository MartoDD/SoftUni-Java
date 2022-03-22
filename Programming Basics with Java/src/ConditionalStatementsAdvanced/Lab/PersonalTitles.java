package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double age = scanner.nextDouble();
        String sex = scanner.next();

        if (sex.equals("m")) {
            if (age >= 16) {
                System.out.println("Mr.");
            } else {
                System.out.println("Master");
            }
        } else {
            if (age >= 16) {
                System.out.println("Ms.");
            } else {
                System.out.println("Miss");
            }
        }
    }
}
