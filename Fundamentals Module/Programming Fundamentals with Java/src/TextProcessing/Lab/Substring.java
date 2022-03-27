package TextProcessing.Lab;

import java.util.Scanner;

public class Substring {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String input = scanner.nextLine();

        int index=input.indexOf(key);
        while (index!=-1){
            input= input.replace(key,"");
            index=input.indexOf(key);
        }
        System.out.println(input);
    }
}
