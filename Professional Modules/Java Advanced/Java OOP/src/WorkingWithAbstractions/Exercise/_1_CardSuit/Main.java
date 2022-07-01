package WorkingWithAbstractions.Exercise._1_CardSuit;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");
        Arrays.stream(CardSuits.values()).forEach(c -> System.out.printf("Ordinal value: %d; Name value: %s%n", c.ordinal(), c));
    }
}