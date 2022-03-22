package WhileLoop.Excersies;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int badGrades = Integer.parseInt(scanner.nextLine());
        String task = scanner.nextLine();
        int grade = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        int count = 0;
        int countBadGrades = 0;
        String tempo;
        boolean pass = true;

        while (true) {
            tempo = task;
            count++;

            if (grade <= 4) {
                countBadGrades++;
            }
            if (countBadGrades >= badGrades) {
                System.out.printf("You need a break, %d poor grades.", countBadGrades);
                pass = false;
                break;
            }

            sum += grade;
            task = scanner.nextLine();
            if (task.equals("Enough")) {
                break;
            }
            grade = Integer.parseInt(scanner.nextLine());


        }
        if (pass) {
            System.out.printf("Average score: %.2f%n", sum / count);
            System.out.printf("Number of problems: %d%n", count);
            System.out.printf("Last problem: %s%n", tempo);
        }
    }
}
