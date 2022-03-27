package WhileLoop.MoreExcersises;

import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String build = "";
        boolean findN = false;
        boolean findC = false;
        boolean findO = false;

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            if (input.matches("[A-Za-z]+")) {

                switch (input) {
                    case "n":
                        if (!findN) {
                            findN = true;
                            input = "";
                        }
                        break;
                    case "o":
                        if (!findO) {
                            findO = true;
                            input = "";
                        }
                        break;
                    case "c":
                        if (!findC) {
                            findC = true;
                            input = "";
                        }
                        break;

                }
                build += input;
                if (findN && findC && findO) {
                    findC = false;
                    findO = false;
                    findN = false;
                    System.out.print(build + " ");
                    build = "";
                }

            }


            input = scanner.nextLine();
        }
    }
}
