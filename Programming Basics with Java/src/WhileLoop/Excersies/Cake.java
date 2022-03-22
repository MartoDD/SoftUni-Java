package WhileLoop.Excersies;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int cakeSize = a * b;
        boolean cakeLeft = false;


        while (cakeSize > 0) {
            String pieces = scanner.nextLine();
            if (pieces.equals("STOP")) {
                cakeLeft = true;
                break;
            }

            cakeSize -= Integer.parseInt(pieces);
        }
        if (cakeLeft) {
            System.out.printf("%d pieces are left.", cakeSize);
        } else {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(cakeSize));
        }
    }
}
