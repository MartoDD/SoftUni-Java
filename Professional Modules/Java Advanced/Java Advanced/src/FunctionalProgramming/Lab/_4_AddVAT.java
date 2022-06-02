package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class _4_AddVAT {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> addVat = d -> d * 1.20;
        Consumer<Double> printer = p -> System.out.printf("%.2f%n", p);

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble).map(addVat).forEach(printer);


    }
}
