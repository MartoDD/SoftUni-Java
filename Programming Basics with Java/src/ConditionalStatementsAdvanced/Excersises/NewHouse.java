package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String flower = scanner.nextLine();
        int flowerCount = scanner.nextInt();
        int budget = scanner.nextInt();
        double totalPrice = 0;

        switch (flower) {
            case "Roses":
                if (flowerCount > 80) {
                    totalPrice = (flowerCount * 5) * 0.90;
                } else {
                    totalPrice = flowerCount * 5;
                }
                break;
            case "Dahlias":
                if (flowerCount > 90) {
                    totalPrice = (flowerCount * 3.80) * 0.85;
                } else {
                    totalPrice = flowerCount * 3.80;
                }
                break;
            case "Tulips":
                if (flowerCount > 80) {
                    totalPrice = (flowerCount * 2.80) * 0.85;
                } else {
                    totalPrice = flowerCount * 2.80;
                }
                break;
            case "Narcissus":
                if (flowerCount < 120) {
                    totalPrice = (flowerCount * 3) * 1.15;
                } else {
                    totalPrice = flowerCount * 3;
                }
                break;
            case "Gladiolus":
                if (flowerCount < 80) {
                    totalPrice = (flowerCount * 2.50) * 1.20;
                } else {
                    totalPrice = flowerCount * 2.50;
                }
                break;

        }
        if (budget >= totalPrice) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowerCount, flower, budget - totalPrice);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", totalPrice - budget);
        }
    }
}
