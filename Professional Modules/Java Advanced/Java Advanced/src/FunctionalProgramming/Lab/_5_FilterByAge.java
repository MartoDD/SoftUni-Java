package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _5_FilterByAge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split(", ");
            Person person = new Person(info[0], Integer.parseInt(info[1]));
            people.add(person);
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String outputFormat = scanner.nextLine();

        people = people.stream().filter(getPredicate(condition, age)).collect(Collectors.toList());

        Consumer<Person> printer = getPrinter(outputFormat);

        people.forEach(printer);


    }

    private static Consumer<Person> getPrinter(String condition) {
        switch (condition) {
            case "name":
                return person -> System.out.println(person.getName());
            case "age":
                return person -> System.out.println(person.getAge());
            case "name age":
                return person -> System.out.println(person.getName() + " - " + person.getAge());
            default:
                throw new IllegalStateException();
        }

    }

    private static Predicate<Person> getPredicate(String condition, int age) {

        switch (condition) {
            case "older":
                return n -> n.getAge() >= age;
            case "younger":
                return n -> n.getAge() <= age;
            default:
                throw new IllegalStateException();
        }
    }

    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
