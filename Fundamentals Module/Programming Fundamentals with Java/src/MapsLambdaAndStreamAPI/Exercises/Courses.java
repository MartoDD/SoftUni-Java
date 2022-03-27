package MapsLambdaAndStreamAPI.Exercises;

import java.util.*;

public class Courses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> students = new LinkedHashMap<>();

        while (!input.equals("end")) {

            String[] data = input.split(" : ");

            students.putIfAbsent(data[0], new ArrayList<>());
            students.get(data[0]).add(data[1]);

            input = scanner.nextLine();

        }
        students.forEach((key, value) -> {
            System.out.println(key + ": " + value.size());
            value.stream().map(s1 -> "-- " + s1).forEach(System.out::println);
        });


    }
}
