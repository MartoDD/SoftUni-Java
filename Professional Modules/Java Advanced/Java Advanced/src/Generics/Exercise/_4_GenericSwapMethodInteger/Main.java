package Generics.Exercise._4_GenericSwapMethodInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Swapper<Integer> swapper = new Swapper<>();

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            swapper.add(Integer.parseInt(input));

        }

        String toSwap = scanner.nextLine();
        int firstIndex = Integer.parseInt(toSwap.split("\\s+")[0]);
        int secondIndex = Integer.parseInt(toSwap.split("\\s+")[1]);

        swapper.swap(firstIndex, secondIndex);

        swapper.print();

    }
}
