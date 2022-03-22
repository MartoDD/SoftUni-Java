package ObjectsАndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Studentss {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            Student student = new Student(info[0], info[1], Double.parseDouble(info[2]));
            students.add(student);
        }

        students.stream().sorted((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade())).forEach(student -> System.out.println(student.print()));

    }

    static class Student {
        String firstName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        String print() {
            return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
        }
    }
}
