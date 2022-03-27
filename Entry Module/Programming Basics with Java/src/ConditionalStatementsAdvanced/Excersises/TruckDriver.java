package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double km = scanner.nextInt();
        double money = 0.00;

        switch (season) {
            case "Winter":
                if (km <= 5000) {
                    money = (km * 1.05) * 0.90;
                } else if (km <= 10000) {
                    money = (km * 1.25) * 0.90;
                } else {
                    money = (km * 1.45) * 0.90;
                }
                break;
            case "Summer":
                if (km <= 5000) {
                    money = (km * 0.90) * 0.90;
                } else if (km <= 10000) {
                    money = (km * 1.10) * 0.90;
                } else {
                    money = (km * 1.45) * 0.90;
                }
                break;
            case "Spring":
            case "Autumn":
                if (km <= 5000) {
                    money = (km * 0.75) * 0.90;
                } else if (km <= 10000) {
                    money = (km * 0.95) * 0.90;
                } else {
                    money = (km * 1.45) * 0.90;
                }
                break;
        }
        money *= 4;
        System.out.printf("%.2f", money);
    }
}
