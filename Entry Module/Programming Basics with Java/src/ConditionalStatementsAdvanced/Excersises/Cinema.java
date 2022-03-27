package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String film = scanner.nextLine();
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        double price;

        switch (film) {
            case "Premiere":
                price = rows * columns * 12.00;
                System.out.printf("%.2f leva", price);
                break;
            case "Normal":
                price = rows * columns * 7.50;
                System.out.printf("%.2f leva", price);
                break;
            case "Discount":
                price = rows * columns * 5.00;
                System.out.printf("%.2f leva", price);
                break;
        }
    }
}
