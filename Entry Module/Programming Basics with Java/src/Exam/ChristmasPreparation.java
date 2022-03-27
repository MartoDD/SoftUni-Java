package Exam;

import java.util.Scanner;

public class ChristmasPreparation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int paperWrap = scanner.nextInt();
        int silkWrap = scanner.nextInt();
        double glue = scanner.nextDouble();
        int discount = scanner.nextInt();

        double totalSum = paperWrap * 5.80 + silkWrap * 7.20 + glue * 1.20;
        double priceDiscounted = totalSum - (totalSum * discount) / 100;

        System.out.printf("%.3f", priceDiscounted);
    }
}
