package ForLoop.Excersises;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double points = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String nameE = scanner.nextLine();
            double pointsE = Double.parseDouble(scanner.nextLine());

            points += nameE.length() * pointsE / 2;

            if (points > 1250.5) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", name, points);
                break;
            }
        }
        if (points <= 1250.5) {
            System.out.printf("Sorry, %s you need %.1f more!", name, 1250.5 - points);
        }
    }
}
