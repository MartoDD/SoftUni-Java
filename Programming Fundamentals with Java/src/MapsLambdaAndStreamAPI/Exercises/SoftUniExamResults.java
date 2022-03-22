package MapsLambdaAndStreamAPI.Exercises;

import java.util.*;

public class SoftUniExamResults {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> submissions = new LinkedHashMap<>();
        Map<String, Integer> results = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {

            String[] data = input.split("-");

            if (!data[1].equals("banned")) {

                submissions.putIfAbsent(data[1], 0);
                submissions.put(data[1], submissions.get(data[1]) + 1);
            }
            if (data.length == 3) {
                
                int value = Integer.parseInt(data[2]);
                results.putIfAbsent(data[0], 0);
                if (results.get(data[0]) < value) {

                    results.put(data[0], Integer.parseInt(data[2]));
                }
            } else if (input.contains("banned")) {
                results.remove(data[0]);
            }


            input = scanner.nextLine();
        }
        System.out.println("Results:");
        results.forEach((k, v) -> System.out.println(k + " | " + v));
        System.out.println("Submissions:");
        submissions.forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
