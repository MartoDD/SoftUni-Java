package MapsLambdaAndStreamAPI.Exercises;

import java.util.*;

public class CompanyUsers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> employees = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] data = input.split(" -> ");

            employees.putIfAbsent(data[0], new ArrayList<>());
            if (!employees.get(data[0]).contains(data[1])) {
                employees.get(data[0]).add(data[1]);
            }
            input = scanner.nextLine();
        }
        employees.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(s -> System.out.println("-- " + s));
        });
    }
}
