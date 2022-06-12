package Generics.Exercise._6_GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box<>();

        while (n-- > 0) {

            double input = Double.parseDouble(scanner.nextLine());

            box.add(input);

        }
        double toCompare = Double.parseDouble(scanner.nextLine());

        System.out.println(box.returnCompared(toCompare));
    }
}
