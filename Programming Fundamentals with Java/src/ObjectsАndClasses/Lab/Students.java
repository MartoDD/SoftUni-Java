package ObjectsАndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Student> students = new ArrayList<>();

        while (!input.equals("end")) {

            String[] data = input.split("\\s+");

            Student student = new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
            students.add(student);

            input = scanner.nextLine();
        }

        String cityName = scanner.nextLine();
        for (Student student : students) {
            if (student.getHometown().equals(cityName)) {
                System.out.println(student.getData());
            }
        }


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

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }
    }
}
