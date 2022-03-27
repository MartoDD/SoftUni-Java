package Arrays.Exercise;

import java.util.Scanner;

public class Train {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int wagons = scanner.nextInt();
        int[] people = new int[wagons];
        int sum = 0;

        for (int i = 0; i < wagons; i++) {
            people[i] = scanner.nextInt();
            sum += people[i];
        }
        for (int person : people) {
            System.out.print(person + " ");
        }
        System.out.printf("%n%d", sum);
    }
}
