package FirstStepsInCoding.Excersises;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double chickenMenu = Double.parseDouble(scanner.nextLine()) * 10.35;
        double fishMenu = Double.parseDouble(scanner.nextLine()) * 12.40;
        double vegMenu = Double.parseDouble(scanner.nextLine()) * 8.15;
        double dessert = (chickenMenu + fishMenu + vegMenu) * 0.2;

        double totalPrice = chickenMenu + fishMenu + vegMenu + dessert + 2.50;
        System.out.println(totalPrice);



    }
}
