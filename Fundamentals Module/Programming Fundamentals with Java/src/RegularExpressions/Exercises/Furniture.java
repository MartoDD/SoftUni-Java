package RegularExpressions.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> stuff = new ArrayList<>();
        double price = 0;
        while (!input.equals("Purchase")) {
            Pattern pattern=Pattern.compile(">>(?<name>\\w+)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name=matcher.group("name");
                double cena =Double.parseDouble(matcher.group("price"));
                int quantity=Integer.parseInt(matcher.group("quantity"));

                stuff.add(name);
                price += cena * quantity;

            }

            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        stuff.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", price);
    }
}
