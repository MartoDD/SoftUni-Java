package ObjectsАndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!input.equals("End")) {
            String[] info = input.split("\\s+");

            Person person = new Person(info[0], info[1], Integer.parseInt(info[2]));
            people.add(person);


            input = scanner.nextLine();
        }

        people.stream().sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())).forEach(person -> System.out.println(person.print()));

    }

    static class Person {
        String name;
        String id;
        int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        String print() {
            return String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
        }
    }
}
