package Lists.Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        List<String> products = new ArrayList<>();

        for (int i = 0; i < number; i++) {

            products.add(scanner.nextLine());
        }
        Collections.sort(products);

        for (int i = 1; i <= products.size(); i++) {
            System.out.println(i + "." + products.get(i - 1));
        }
    }
}



