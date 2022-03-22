package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class PokeMon {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int y = scanner.nextInt();
        int secondN = n;

        int pokeCounter = 0;

        while (n >= m) {
            pokeCounter++;

            n -= m;

            if (n == (secondN / 2.0) && y>0) {

                n /= y;
            }
        }
        System.out.println(n);
        System.out.println(pokeCounter);

    }
}
