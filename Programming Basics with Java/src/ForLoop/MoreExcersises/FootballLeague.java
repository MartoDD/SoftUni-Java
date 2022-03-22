package ForLoop.MoreExcersises;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int stadium = scanner.nextInt();
        int fans = scanner.nextInt();
        String sector;

        int a = 0;
        int b = 0;
        int v = 0;
        int g = 0;

        for (int i = 0; i < fans; i++) {

            sector = scanner.next();

            switch (sector) {
                case "A":
                    a++;
                    break;
                case "B":
                    b++;
                    break;
                case "V":
                    v++;
                    break;
                case "G":
                    g++;
                    break;
            }
        }
        System.out.printf("%.2f%%%n", a * 1.0 / fans * 100);
        System.out.printf("%.2f%%%n", b * 1.0 / fans * 100);
        System.out.printf("%.2f%%%n", v * 1.0 / fans * 100);
        System.out.printf("%.2f%%%n", g * 1.0 / fans * 100);
        System.out.printf("%.2f%%%n", (a + b + v + g) * 1.0 / stadium * 100);

    }
}
