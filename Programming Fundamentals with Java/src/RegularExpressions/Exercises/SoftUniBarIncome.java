package RegularExpressions.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String regEx = "%(?<customer>[A-Z][a-z]+)%[^|$%.]*?<(?<product>\\w+)>[^|$%.]*?\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+[\\.]?\\d+)\\$";

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("%(?<customer>[A-Z][a-z]+)%[^|$%.]*?<(?<product>\\w+)>[^|$%.]*?\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+[\\.]?\\d+)\\$");
        double sum = 0;
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            String customerName;
            String product;
            double totalPrice;
            if (input.matches(regEx)) {
                while (matcher.find()) {
                    product = matcher.group("product");
                    customerName = matcher.group("customer");
                    totalPrice = Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("count"));
                    sum += totalPrice;
                    System.out.printf("%s: %s - %.2f%n", customerName, product, totalPrice);
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", sum);
    }
}
