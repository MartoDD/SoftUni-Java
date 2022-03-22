package Exam;

import java.util.Scanner;

public class DeerOfSanta {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = scanner.nextInt();
        int kgFood = scanner.nextInt();
        double firstDeer = scanner.nextDouble();
        double secondDeer = scanner.nextDouble();
        double thirdDeer = scanner.nextDouble();

        double totalNeeds = (firstDeer + secondDeer + thirdDeer) * days;

        if (totalNeeds <= kgFood) {
            System.out.printf("%.0f kilos of food left.", Math.floor(kgFood - totalNeeds));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(totalNeeds - kgFood));
        }
    }
}
