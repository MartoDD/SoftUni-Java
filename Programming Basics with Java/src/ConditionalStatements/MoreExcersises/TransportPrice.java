package ConditionalStatements.MoreExcersises;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int km = scanner.nextInt();
        String dayNight = scanner.next();

        double taxiPriceDay = km * 0.79 + 0.70;
        double taxiPriceNight = km * 0.90 + 0.70;
        double bussPrice = km * 0.09;
        double trainPrice = km * 0.06;

        if (km < 20) {
            if (dayNight.equals("day")) {
                System.out.printf("%.2f", taxiPriceDay);
            } else {
                System.out.printf("%.2f", taxiPriceNight);
            }
        } else if (km < 100) {
            System.out.printf("%.2f", bussPrice);
        } else {
            System.out.printf("%.2f", trainPrice);
        }
    }
}
