package Generics.Exercise._8_CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        CustomList<String> customList = new CustomList<>();

        while (!input.equals("END")) {

            String command = input.split("\\s")[0];
            switch (command) {
                case "Add":
                    String toAdd = input.split("\\s")[1];
                    customList.add(toAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(input.split("\\s")[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String contains = input.split("\\s")[1];
                    System.out.println(customList.contains(contains));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(input.split("\\s")[1]);
                    int secondIndex = Integer.parseInt(input.split("\\s")[2]);
                    customList.swaps(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String forGreater = input.split("\\s")[1];
                    System.out.println(customList.countGreaterThan(forGreater));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                case "Print":
                    customList.print();
                    break;
            }

            input = scanner.nextLine();
        }


    }
}
