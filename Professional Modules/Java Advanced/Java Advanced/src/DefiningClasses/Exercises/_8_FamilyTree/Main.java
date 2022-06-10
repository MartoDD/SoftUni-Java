package DefiningClasses.Exercises._8_FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String searchPersonByValue = scanner.nextLine();

        Map<String, Person> people = new LinkedHashMap<>();
        List<String> data = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            if (!input.contains("-")) {
                String name = input.substring(0, input.lastIndexOf(" "));
                String birthday = input.substring(input.lastIndexOf(" ") + 1);
                Person person = new Person(name, birthday);
                people.put(name, person);
            } else {
                data.add(input);
            }

            input = scanner.nextLine();
        }

        for (String line : data) {
            String parent = line.split(" - ")[0];
            String child = line.split(" - ")[1];

            if (!parent.contains("/")) {
                if (people.containsKey(parent)) {
                    people.get(parent).getChildren().add(child);
                }
            } else {
                for (Person value : people.values()) {
                    if (value.getBirthday().equals(parent)) {
                        value.getChildren().add(child);
                    }
                }

            }
            if (!child.contains("/")) {
                if (people.containsKey(child)) {
                    people.get(child).getParents().add(parent);
                }
            } else {
                for (Person value : people.values()) {
                    if (value.getBirthday().equals(child)) {
                        value.getParents().add(parent);
                    }
                }

            }
        }

        if (searchPersonByValue.contains("/")) {
            searchPersonByValue = getInfo(people, searchPersonByValue);
            searchPersonByValue = searchPersonByValue.substring(0, searchPersonByValue.lastIndexOf(" "));
        }
        System.out.println(getInfo(people, searchPersonByValue));
        System.out.println("Parents:");
        people.get(searchPersonByValue).getParents().forEach(parent -> System.out.println(getInfo(people, parent)));
        System.out.println("Children:");
        people.get(searchPersonByValue).getChildren().forEach(child -> System.out.println(getInfo(people, child)));


    }

    private static String getInfo(Map<String, Person> people, String information) {
        String output = "";

        if (!information.contains("/")) {
            output = information + " " + people.get(information).getBirthday();
        } else {
            for (Person person : people.values()) {
                if (person.getBirthday().equals(information)) {
                    output = person.getName() + " " + information;
                }
            }

        }

        return output;
    }
}
