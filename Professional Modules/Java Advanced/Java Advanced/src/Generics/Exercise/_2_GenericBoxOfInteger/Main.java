package Generics.Exercise._2_GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Box<Integer> box = new Box<>(Integer.parseInt(input));
            System.out.println(box);
        }
    }
}
