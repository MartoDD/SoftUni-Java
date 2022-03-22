package TextProcessing.MoreExercises;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String title= scanner.nextLine();
        String content= scanner.nextLine();
        System.out.println("<h1>\n   " + title + "\n</h1>");
        System.out.println("<article>\n   " + content + "\n</article>");

        String comment= scanner.nextLine();
        while (!comment.equals("end of comments")){

            System.out.println("<div>\n" + comment + "\n</div>");
            comment= scanner.nextLine();
        }
    }
}
