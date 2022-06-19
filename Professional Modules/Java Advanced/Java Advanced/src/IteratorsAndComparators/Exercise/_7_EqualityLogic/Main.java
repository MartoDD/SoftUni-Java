package IteratorsAndComparators.Exercise._7_EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<Person> tree = new TreeSet<>();
        HashSet<Person> hash = new HashSet<>();
        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);
            tree.add(person);
            hash.add(person);
        }

        System.out.println(tree.size());
        System.out.println(hash.size());

    }

}
