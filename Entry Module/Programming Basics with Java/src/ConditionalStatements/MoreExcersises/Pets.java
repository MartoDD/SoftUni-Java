package ConditionalStatements.MoreExcersises;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = scanner.nextInt();
        int foodKg = scanner.nextInt();
        double dogFood = scanner.nextDouble() * days;
        double catFood = scanner.nextDouble() * days;
        double turtleFood = (scanner.nextDouble() * days) / 1000;

        double totalFoodNeeded = dogFood + catFood + turtleFood;

        if (totalFoodNeeded <= foodKg) {
            System.out.printf("%.0f kilos of food left.", Math.floor(foodKg - totalFoodNeeded));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(totalFoodNeeded - foodKg));
        }


    }
}
