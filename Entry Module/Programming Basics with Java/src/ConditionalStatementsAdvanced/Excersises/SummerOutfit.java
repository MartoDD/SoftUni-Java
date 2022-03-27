package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int temp = scanner.nextInt();
        String time = scanner.next();
        String outfit = "";
        String shoes = "";

        switch (time) {
            case "Morning":
                if (temp >= 10 && temp <= 18) {
                    outfit = "Sweatshirt";
                    shoes = "Sneakers";
                } else if (temp > 18 && temp <= 24) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                } else {
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                }
                break;
            case "Afternoon":
                if (temp >= 10 && temp <= 18) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                } else if (temp > 18 && temp <= 24) {
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                } else {
                    outfit = "Swim Suit";
                    shoes = "Barefoot";
                }
                break;
            case "Evening":
                if (temp >= 10 && temp <= 18) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                } else if (temp > 18 && temp <= 24) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                } else {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                }
                break;
        }
        System.out.printf("It's %d degrees, get your %s and %s.", temp, outfit, shoes);
    }
}
