package ObjectsАndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsTwo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Student> students = new ArrayList<>();

        while (!input.equals("end")) {

            String[] data = input.split("\\s+");


            if (isStudentExisting(students, data[0], data[1])) {
                Student student = getStudent(students, data[0], data[1]);
                student.setFirstName(data[0]);
                student.setLastName(data[1]);
                student.setAge(Integer.parseInt(data[2]));
                student.setHometown(data[3]);

            } else {
                Student student = new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
                students.add(student);
            }


            input = scanner.nextLine();
        }

        String cityName = scanner.nextLine();
        for (Student student : students) {
            if (student.getHometown().equals(cityName)) {
                System.out.println(student.getData());
            }
        }


    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        Student existingStudent = null;
        for (Student student : students) {
            if ((student.getFirstName().equals(firstName)) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }
        return existingStudent;

    }

    private static boolean isStudentExisting(List<Student> students, String firstName, String lastName) {

        for (Student student : students) {
            if ((student.getFirstName().equals(firstName)) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    static class Student {

        String firstName;
        String lastName;
        int age;
        String hometown;

        public Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public String getData() {
            return String.format("%s %s is %d years old", this.firstName, this.lastName, this.age);
        }

        public String getHometown() {
            return hometown;
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

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }
    }
}
