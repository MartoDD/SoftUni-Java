package Polymorphism.Exercise._3_WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Mammal> mammals = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] animal = input.split("\\s+");
            String[] food = scanner.nextLine().split("\\s+");

            String animalType = animal[0];
            Food food1 = getFood(food);
            Mammal mammal = null;
            switch (animalType) {
                case "Cat":
                    mammal = new Cat(animal[0], animal[1], Double.parseDouble(animal[2]), animal[3], animal[4]);
                    break;
                case "Tiger":
                    mammal = new Tiger(animal[0], animal[1], Double.parseDouble(animal[2]), animal[3]);
                    break;
                case "Mouse":
                    mammal = new Mouse(animal[0], animal[1], Double.parseDouble(animal[2]), animal[3]);
                    break;
                case "Zebra":
                    mammal = new Zebra(animal[0], animal[1], Double.parseDouble(animal[2]), animal[3]);
                    break;
            }
            assert mammal != null;
            mammal.makeSound();
            try {
                mammal.eat(food1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            mammals.add(mammal);

            input = scanner.nextLine();
        }
        for (Mammal mammal : mammals) {
            System.out.println(mammal);
        }

    }

    private static Food getFood(String[] food) {
        switch (food[0]) {
            case "Vegetable":
                return new Vegetable(Integer.parseInt(food[1]));
            case "Meat":
                return new Meat(Integer.parseInt(food[1]));
            default:
                throw new IllegalArgumentException();
        }

    }
}
