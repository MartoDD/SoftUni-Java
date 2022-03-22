package WhileLoop.Excersies;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int totalVolume = a * b * c;
        boolean noMoreRoom = false;

        while (totalVolume > 0) {
            String input = scanner.nextLine();
            if (input.equals("Done")) {
                noMoreRoom = true;
                break;
            }
            totalVolume -= Integer.parseInt(input);
        }
        if (!noMoreRoom) {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(totalVolume));
        } else {
            System.out.printf("%d Cubic meters left.", totalVolume);
        }
    }
}
