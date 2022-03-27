package ConditionalStatements.Excersises;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double record = scanner.nextDouble();
        double distance = scanner.nextDouble();
        double time = scanner.nextDouble();

        double timeTotal = distance * time;
        double timeAdded = (Math.floor(distance / 15.0)) * 12.5;
        double timeAll = timeTotal + timeAdded;

        if (timeAll < record) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", timeAll);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", timeAll - record);
        }

    }
}
