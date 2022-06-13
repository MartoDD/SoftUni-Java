package Generics.Exercise._10_Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String name = input.substring(0, input.lastIndexOf(" "));
        String address = input.substring(input.lastIndexOf(" ") + 1);

        Tuple<String, String> tuple1 = new Tuple<>(name, address);

        input = scanner.nextLine();
        name = input.substring(0, input.lastIndexOf(" "));
        int beer = Integer.parseInt(input.substring(input.lastIndexOf(" ") + 1));

        Tuple<String, Integer> tuple2 = new Tuple<>(name, beer);

        input = scanner.nextLine();
        int integer = Integer.parseInt(input.split("\\s+")[0]);
        double doubl = Double.parseDouble(input.split("\\s+")[1]);

        Tuple<Integer, Double> tuple3 = new Tuple<>(integer, doubl);

        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);
    }
}
