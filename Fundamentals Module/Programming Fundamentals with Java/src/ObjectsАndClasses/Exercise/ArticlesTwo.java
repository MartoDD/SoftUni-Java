package ObjectsАndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticlesTwo {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split(", ");
            Article article = new Article(info[0], info[1], info[2]);
            articles.add(article);
        }
        String input = scanner.nextLine();

        switch (input) {
            case "title":
                articles.stream().sorted((a1, a2) -> a1.getTitle().compareTo(a2.getTitle())).forEach(article -> System.out.println(article.toString()));
                break;
            case "content":
                articles.stream().sorted((a1, a2) -> a1.getCont().compareTo(a2.getCont())).forEach(article -> System.out.println(article.toString()));
                break;
            case "author":
                articles.stream().sorted((a1, a2) -> a1.getAuthor().compareTo(a2.getAuthor())).forEach(article -> System.out.println(article.toString()));
                break;
        }


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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCont() {
            return cont;
        }

        public void setCont(String cont) {
            this.cont = cont;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title, this.cont, this.author);
        }
    }
}
