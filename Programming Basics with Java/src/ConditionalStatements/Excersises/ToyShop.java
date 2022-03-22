package ConditionalStatements.Excersises;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double tripPrice = scanner.nextDouble();
        int puzzle = scanner.nextInt();
        int talkingDoll = scanner.nextInt();
        int teddyBear = scanner.nextInt();
        int minions = scanner.nextInt();
        int trucks = scanner.nextInt();
        int totalToys = puzzle + talkingDoll + teddyBear + minions + trucks;
        double totalPrice = puzzle * 2.60 + talkingDoll * 3 + teddyBear * 4.10 + minions * 8.20 + trucks * 2;
        double discount;
        double rent;
        double profit;
        if (totalToys >= 50) {
            discount = totalPrice * 0.25;
            rent = (totalPrice - discount) * 0.1;
            profit = totalPrice - discount - rent;
        } else {
            rent = totalPrice * 0.1;
            profit = totalPrice - rent;
        }
        if (profit >= tripPrice) {
            double remainder = profit - tripPrice;
            System.out.print("Yes! ");
            System.out.printf("%.2f lv left.", remainder);
        } else {
            double needed = tripPrice - profit;
            System.out.print("Not enough money! ");
            System.out.printf("%.2f lv needed.", needed);
        }
    }
}
