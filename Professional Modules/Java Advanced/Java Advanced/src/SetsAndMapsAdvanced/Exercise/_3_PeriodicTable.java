package SetsAndMapsAdvanced.Exercise;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _3_PeriodicTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] elementInput = scanner.nextLine().split("\\s+");
            Collections.addAll(elements, elementInput);
        }

        System.out.println(String.join(" ", elements));
    }
}
