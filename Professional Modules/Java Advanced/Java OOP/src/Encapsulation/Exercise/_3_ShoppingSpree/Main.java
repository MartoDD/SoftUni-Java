package Encapsulation.Exercise._3_ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String[] people = scanner.nextLine().split(";");
        Map<String, Person> ppl = new LinkedHashMap<>();
        for (String person : people) {
            String[] tokens = person.split("=");
            try {
                Person person1 = new Person(tokens[0], Double.parseDouble(tokens[1]));
                ppl.put(tokens[0], person1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String[] products = scanner.nextLine().split(";");
        Map<String, Product> productList = new LinkedHashMap<>();
        for (String product : products) {
            String[] tokens = product.split("=");
            try {
                Product product1 = new Product(tokens[0], Double.parseDouble(tokens[1]));
                productList.put(tokens[0], product1);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] info = input.split("\\s+");
            try {
                ppl.get(info[0]).buyProduct(productList.get(info[1]));
                System.out.println(info[0] + " bought " + info[1]);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }

        for (Person value : ppl.values()) {
            if (value.getProducts().size() == 0) {
                System.out.println(value.getName() + " - Nothing bought");
            } else {
                System.out.println(value.getName() + " - " + value.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
            }
        }

    }
}
