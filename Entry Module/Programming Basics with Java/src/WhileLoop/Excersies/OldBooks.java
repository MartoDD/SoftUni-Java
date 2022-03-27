package WhileLoop.Excersies;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String book = scanner.nextLine();
        String input = scanner.nextLine();
        int count = 0;
        boolean found = false;

        while (!input.equals("No More Books")) {

            count++;
            if (input.equals(book)){
                System.out.printf("You checked %d books and found it.", count-1);
                found=true;
                break;
            }
            input= scanner.nextLine();
        }
        if (!found){
            System.out.printf("The book you search is not here! %nYou checked %d books.",count);

        }
    }
}
