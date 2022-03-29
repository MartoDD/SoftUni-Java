package FinalExamPreparation.MockExamFour;

import java.util.Scanner;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regEx = "@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+";
        Pattern pattern = Pattern.compile(regEx);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.matches(regEx)) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < input.length(); j++) {
                    if (Character.isDigit(input.charAt(j))) {
                        temp.append(input.charAt(j));
                    }
                }
                if (temp.length() != 0) {
                    System.out.println("Product group: " + temp);
                } else {
                    System.out.println("Product group: 00");
                }
            } else {
                System.out.println("Invalid barcode");
            }

        }
    }
}
