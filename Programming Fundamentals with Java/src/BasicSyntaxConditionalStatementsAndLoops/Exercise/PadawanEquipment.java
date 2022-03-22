package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceLightsaber = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());
        double totalBelt;
        double totalLight = Math.ceil(students * 1.10) * priceLightsaber;
        double totalRobe = students * priceRobe;
        if (students >= 6) {
            int temStudents = students - (students / 6);
            totalBelt = temStudents * priceBelts;
        } else {
            totalBelt = students * priceBelts;
        }

        double totalPrice = totalBelt + totalLight + totalRobe;

        if (money >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.%n", totalPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - money);
        }

    }
}

