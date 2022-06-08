package DefiningClasses.Exercises._7_Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Person> people = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            people.putIfAbsent(name, new Person(name));
            switch (data[1]) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department, salary);
                    people.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    people.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    people.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    Child child = new Child(childName, childBirthday);
                    people.get(name).getChildren().add(child);
                    break;
                case "car":
                    String carModel = data[2];
                    int carSpeed = Integer.parseInt(data[3]);
                    Car car = new Car(carModel, carSpeed);
                    people.get(name).setCar(car);
                    break;
            }


            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        System.out.print(people.get(input));
        System.out.println("Pokemon:");
        people.get(input).getPokemons().forEach(System.out::println);
        System.out.println("Parents:");
        people.get(input).getParents().forEach(System.out::println);
        System.out.println("Children:");
        people.get(input).getChildren().forEach(System.out::println);
    }
}
