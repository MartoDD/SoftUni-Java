package Encapsulation.Exercise._4_PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {


            Scanner scanner = new Scanner(System.in);

            String[] input = scanner.nextLine().split("\\s+");
            String pizzaName = input[1];
            int toppingsNumber = Integer.parseInt(input[2]);
            Pizza pizza;
            Dough dough;
            pizza = new Pizza(pizzaName, toppingsNumber);

            String[] tokens = scanner.nextLine().split("\\s+");
            String flourType = tokens[1];
            String technique = tokens[2];
            int weight = Integer.parseInt(tokens[3]);

            dough = new Dough(flourType, technique, weight);
            pizza.setDough(dough);


            String toppings = scanner.nextLine();

            while (!"END".equals(toppings)) {


                String[] elements = toppings.split("\\s+");
                String name = elements[1];
                int weightt = Integer.parseInt(elements[2]);
                Topping topping = new Topping(name, weight);
                pizza.addTopping(topping);


                toppings = scanner.nextLine();
            }

            System.out.printf("%s - %.2f", pizzaName, pizza.getOverallCalories());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
