package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class _5_AverageStudentsGrades {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String studentName = input[0];
            double studentGrade = Double.parseDouble(input[1]);
            students.putIfAbsent(studentName, new ArrayList<>());
            students.get(studentName).add(studentGrade);

        }

        for (var entry : students.entrySet()) {
            double sum = 0;
            for (Double aDouble : entry.getValue()) {
                sum += aDouble;
            }
            double avg = sum / entry.getValue().size();

            System.out.print(entry.getKey() + " -> ");
            for (Double aDouble : entry.getValue()) {
                System.out.printf("%.2f ", aDouble);
            }
            System.out.printf("(avg: %.2f)%n", avg);


        }

    }
}
