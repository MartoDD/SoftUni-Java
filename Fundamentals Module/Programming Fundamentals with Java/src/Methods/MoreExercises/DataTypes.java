package Methods.MoreExercises;

import java.util.Scanner;

public class DataTypes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input) {
            case "int":
                int a = Integer.parseInt(scanner.nextLine());
                printMultiplyByTwo(a);
                break;
            case "real":
                double b = Double.parseDouble(scanner.nextLine());
                printMultiplyBy(b);
                break;
            case "string":
                String c = scanner.nextLine();
                printWithSymbol(c);
                break;
        }
    }

    private static void printWithSymbol(String c) {
        System.out.println("$" + c + "$");
    }

    private static void printMultiplyBy(double b) {

        System.out.printf("%.2f", b * 1.5);
    }

    private static void printMultiplyByTwo(int a) {

        System.out.println(a * 2);
    }


}
