package ObjectsАndClasses.MoreExercises;

import java.util.*;

public class CompanyRoster {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Employee employee = new Employee();
            employee.setName(input[0]);
            employee.setSalary(Double.parseDouble(input[1]));
            employee.setPosition(input[2]);
            employee.setDepartment(input[3]);

            switch (input.length) {
                case 5:
                    if (input[4].contains("@")) {
                        employee.setEmail(input[4]);
                    } else {
                        employee.setAge(Integer.parseInt(input[4]));
                    }
                    break;
                case 6:
                    employee.setEmail(input[4]);
                    employee.setAge(Integer.parseInt(input[5]));
            }

            employees.add(employee);
        }
        for (Employee e : employees) {
            if (departments.size() == 0) {
                Department dp = new Department(e.getDepartment(), new ArrayList<>());

                dp.getEmployees().add(e);
                departments.add(dp);
            } else {
                boolean isPresent = false;
                for (Department d : departments) {
                    if (d.getName().equals(e.getDepartment())) {
                        d.getEmployees().add(e);
                        isPresent = true;
                    }
                }
                if (!isPresent) {
                    Department dp = new Department(e.getDepartment(), new ArrayList<>());
                    dp.getEmployees().add(e);
                    departments.add(dp);
                }
            }

        }
        double biggestSum = 0;
        Department bigDep = new Department();
        for (Department d : departments) {
            int counter = 0;
            double sum = 0;
            for (Employee employee : d.getEmployees()) {
                counter++;
                sum += employee.getSalary();
            }
            double average = sum / counter;
            if (average > biggestSum) {
                biggestSum = average;
                bigDep = d;
            }

        }
        System.out.printf("Highest Average Salary: %s%n", bigDep.getName());
        bigDep.getEmployees().stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).forEach(employee -> System.out.println(employee.print()));


    }

    static class Department {
        String name;
        List<Employee> employees;

        public Department(String name, List<Employee> employees) {
            this.name = name;
            this.employees = employees;
        }

        public Department() {

        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public List<Employee> getEmployees() {
            return employees;
        }


    }

    static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        Employee() {
            this.email = "n/a";
            this.age = -1;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        String print() {
            return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
        }
    }
}
