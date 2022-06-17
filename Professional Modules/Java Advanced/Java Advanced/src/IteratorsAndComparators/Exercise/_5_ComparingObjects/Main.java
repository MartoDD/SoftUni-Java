package IteratorsAndComparators.Exercise._5_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]), data[2]);
            people.add(person);

            input = scanner.nextLine();
        }

        int index = Integer.parseInt(scanner.nextLine()) - 1;

        Person theChosen = people.get(index);

        int equalPeople = 0;
        int differentPeople = 0;
        int totalPeople = people.size();

        for (Person person : people) {
            if (person.compareTo(theChosen) == 0) {
                equalPeople++;
            } else {
                differentPeople++;
            }
        }
        if (equalPeople > 1) {
            System.out.println(equalPeople + " " + differentPeople + " " + totalPeople);
        } else {
            System.out.println("No matches");
        }

    }
}
