package Methods.Lab;

import java.util.Scanner;

public class Orders {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        double finalPrice= calculateFinalPrice(type,quantity);
        printFinalResult(finalPrice);
    }

    private static void printFinalResult(double finalPrice) {
        System.out.printf("%.2f",finalPrice);
    }

    private static double calculateFinalPrice(String type, int quantity) {
        double price=0;
        double finalPrice=0;
        switch (type){
            case "coffee":
                price=1.50;
                finalPrice=price*quantity;
                break;
            case "water":
                price=1.00;
                finalPrice=price*quantity;
                break;
            case "coke":
                price=1.40;
                finalPrice=price*quantity;
                break;
            case "snacks":
                price=2.00;
                finalPrice=price*quantity;
                break;
        }

        return finalPrice;
    }
}
