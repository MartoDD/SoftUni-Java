package ObjectsАndClasses.Exercise;

import java.util.Scanner;

public class Articles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        Article article = new Article(input[0], input[1], input[2]);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(": ");
            switch (command[0]) {
                case "Edit":
                    article.edit(command[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(command[1]);
                    break;
                case "Rename":
                    article.rename(command[1]);
                    break;
            }
        }
        System.out.println(article.toString());


    }

    static class Article {
        String title;
        String cont;
        String author;

        public Article(String title, String cont, String author) {
            this.title = title;
            this.cont = cont;
            this.author = author;
        }

        void edit(String cont) {
            this.cont = cont;
        }

        void changeAuthor(String author) {
            this.author = author;
        }

        void rename(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title, this.cont, this.author);
        }
    }
}
