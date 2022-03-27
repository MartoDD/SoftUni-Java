package MidExam;

import java.util.Scanner;

public class CookingMasterclass {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceFlour = Double.parseDouble(scanner.nextLine());
        double priceEgg = Double.parseDouble(scanner.nextLine());
        double priceApron = Double.parseDouble(scanner.nextLine());

        double totalApron = priceApron * (Math.ceil(students * 1.20));
        double totalFlour = priceFlour * (students - (Math.floor((double) students / 5)));
        double totalEggs = priceEgg * 10 * students;
        double total = totalApron + totalEggs + totalFlour;
        if (total <= budget) {
            System.out.printf("Items purchased for %.2f$.", total);
        } else {
            System.out.printf("%.2f$ more needed.", total - budget);
        }
    }
}
