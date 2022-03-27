package NestedLoops.Excersises;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int jury = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        double finalSum=0;
        int counter=0;

        String presentation = scanner.nextLine();

        while (!presentation.equals("Finish")) {

            for (int i = 1; i <= jury; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                sum += grade;
                counter++;
            }
            double avg = (double) sum/ jury;
            System.out.printf("%s - %.2f.%n", presentation, avg);
            finalSum+=sum;
            sum=0;


            presentation = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.",finalSum/counter);
    }
}
