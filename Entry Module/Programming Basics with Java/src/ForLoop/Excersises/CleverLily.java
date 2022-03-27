package ForLoop.Excersises;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int age = scanner.nextInt();
        double priceWash = scanner.nextDouble();
        int priceToy = scanner.nextInt();

        double money = 0;
        int toys = 0;

        for (int i = 1; i <= age; i++) {

            if (i % 2 == 0) {
                money += 10 * (i / 2) - 1;
            } else {
                toys++;
            }
        }
        money = money + toys * priceToy;

        if (money >= priceWash) {
            System.out.printf("Yes! %.2f", money - priceWash);
        } else {
            System.out.printf("No! %.2f", priceWash - money);
        }
    }
}
