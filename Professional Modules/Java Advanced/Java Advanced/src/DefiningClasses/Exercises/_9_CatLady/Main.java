package DefiningClasses.Exercises._9_CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            Cat cat = null;
            switch (data[0]) {
                case "Siamese":
                    cat = new Siamese(data[0], data[1], Double.parseDouble(data[2]));
                    break;
                case "Cymric":
                    cat = new Cymric(data[0], data[1], Double.parseDouble(data[2]));
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(data[0], data[1], Double.parseDouble(data[2]));
                    break;
            }
            cats.put(data[1], cat);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        System.out.println(cats.get(input));
    }
}
