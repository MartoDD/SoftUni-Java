package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x =Double.parseDouble(scanner.nextLine());
        double y =Double.parseDouble(scanner.nextLine());
        double h =Double.parseDouble(scanner.nextLine());

        double green = ((x * x * 2) + (x * y * 2) - (2 * 1.2) - (1.5 * 1.5 * 2)) / 3.4;
        double red = ((x * y * 2) + 2*(x * h/ 2)) / 4.3;

        System.out.printf("%.2f%n%.2f", green, red);

        }
    }

