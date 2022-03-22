package ConditionalStatements.MoreExcersises;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int z = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        double price = scanner.nextDouble();

        double totalPrice = (m * 3.25 + z * 4 + r * 3.5 + c * 8) * 0.95;

        if (totalPrice >= price) {
            System.out.printf("She is left with %.0f leva.",Math.floor(totalPrice - price));
        }else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(price - totalPrice));
        }
    }
}
