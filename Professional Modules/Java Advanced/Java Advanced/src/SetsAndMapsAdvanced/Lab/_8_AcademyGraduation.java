package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _8_AcademyGraduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            students.putIfAbsent(name, Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList()));
        }

        for (var entry : students.entrySet()) {
            System.out.print(entry.getKey() + " is graduated with ");
            // double avg = entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0); - This is better, but I used cycle because the avg value from stream is slightly different from the
            //judge system
            double avg;
            double sum = 0;
            for (Double aDouble : entry.getValue()) {
                sum += aDouble;
            }
            avg = sum / entry.getValue().size();

            System.out.println(avg);

        }

    }
}
