package DefiningClasses.Exercises._2_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> departments = new HashMap<>();

        while (n-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            String email;
            int age;
            Employee employee = null;
            switch (data.length) {
                case 6:
                    email = data[4];
                    age = Integer.parseInt(data[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
                case 5:
                    if (data[data.length - 1].contains("@")) {
                        email = data[4];
                        employee = new Employee(name, salary, position, department, email);
                    } else {
                        age = Integer.parseInt(data[4]);
                        employee = new Employee(name, salary, position, department, age);
                    }
                    break;
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
            }
            departments.putIfAbsent(department, new ArrayList<>());
            departments.get(department).add(employee);

        }
        String highestDep = "";
        double highestAvg = Double.MIN_VALUE;


        for (var entry : departments.entrySet()) {

            double avg = entry.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(0);
            if (avg > highestAvg) {
                highestAvg = avg;
                highestDep = entry.getKey();
            }
        }
        System.out.println("Highest Average Salary: " + highestDep);
        departments.get(highestDep).stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).forEach(employee1 -> System.out.println(employee1.getInfo()));
    }
}
