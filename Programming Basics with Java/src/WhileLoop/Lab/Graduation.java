package WhileLoop.Lab;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int counter = 1;
        int counter2 = 0;
        double sum = 0;
        boolean pass = true;

        while (counter <= 12) {

            double input = scanner.nextDouble();
            if (input < 4) {
                counter2++;
            }
            if (counter2 >= 2) {
                pass = false;
                break;
            }
            sum += input;
            counter++;

        }
        if (pass) {
            System.out.printf("%s graduated. Average grade: %.2f", name, sum / 12);
        } else {
            System.out.printf("%s has been excluded at %d grade", name, counter - 1);
        }
    }
}
