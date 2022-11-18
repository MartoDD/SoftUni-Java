package com.example.bookshopsystem;

import com.example.bookshopsystem.Constants.Messages;
import com.example.bookshopsystem.services.author.AuthorService;
import com.example.bookshopsystem.services.book.BookService;
import com.example.bookshopsystem.services.seed.SeedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);
    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;


    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {

        //seedAll();
        System.out.println(Messages.INTRO_MESSAGE);

        int number = Integer.parseInt(scanner.nextLine());

        switch (number) {
            case 1:
                bookTitlesByAgeRestriction();
                break;
            case 2:
                goldenBooks();
                break;
            case 3:
                booksByPrice();
                break;
            case 4:
                notReleasedBooks();
                break;
            case 5:
                booksReleasedBefore();
                break;
            case 6:
                authorsSearch();
                break;
            case 7:
                booksSearch();
                break;
            case 8:
                bookTitlesSearch();
                break;
            case 9:
                countBooks();
                break;
            case 10:
                totalBookCopies();
                break;
            case 11:
                reducedBook();
                break;
            case 12:
                increaseBookCopies();
                break;
            case 13:
                removeBooks();
                break;
            case 14:
                /*USE bookshop;

                DELIMITER $$

                CREATE PROCEDURE `total_books_written_by`(IN name VARCHAR(50), OUT count INT)
                BEGIN

                SELECT COUNT(b.id) FROM authors AS a
                JOIN books AS b ON a.id=b.author_id
                WHERE CONCAT(a.`first_name`," ",a.`last_name`) LIKE name;

                END*/
                storedProcedure();
                break;
            default:
                System.out.println("Невалиден номер на задача");
                run();
        }

    }

    private void storedProcedure() {
        System.out.println(Messages.TASK_FOURTEEN_INTRO_MESSAGE);
        System.out.println(Messages.TASK_FOURTEEN_INPUT_MESSAGE);
        String name= scanner.nextLine();

        System.out.println(authorService.getCountOfBooksWrittenByAuthor(name));
    }

    public void seedAll() throws IOException {
        seedService.seedAll();
    }

    private void removeBooks() {
        System.out.println(Messages.TASK_THIRTEEN_INTRO_MESSAGE);
        System.out.println(Messages.TASK_THIRTEEN_INPUT_MESSAGE);

        int numberOfCopies = Integer.parseInt(scanner.nextLine());
        int count = bookService.deleteBookByCopiesLessThan(numberOfCopies);
        System.out.println(count);
    }

    private void increaseBookCopies() {
        System.out.println(Messages.TASK_TWELVE_INTRO_MESSAGE);
        System.out.println(Messages.TASK_TWELVE_INPUT_MESSAGE);
        String[] date = scanner.nextLine().split(" ");
        int copies = Integer.parseInt(scanner.nextLine());
        int month = Utils.monthConverter(date[1]);
        LocalDate localDate = LocalDate.of(Integer.parseInt(date[2]), month, Integer.parseInt(date[0]));

        int numberOfCopies = bookService.increaseCopiesOfBooksAfterAGivenDate(localDate, copies);
        System.out.println(numberOfCopies * copies);
    }

    private void reducedBook() {
        System.out.println(Messages.TASK_ELEVEN_INTRO_MESSAGE);
        System.out.println(Messages.TASK_ELEVEN_INPUT_MESSAGE);
        String bookTitle = scanner.nextLine();

        bookService.getBookInformationByBookTitle(bookTitle).forEach(System.out::println);
    }

    private void totalBookCopies() {
        System.out.println(Messages.TASK_TEN_INTRO_MESSAGE);

        System.out.println(authorService.getAuthorsByBookCount());
    }

    private void countBooks() {
        System.out.println(Messages.TASK_NINE_INTRO_MESSAGE);
        System.out.println(Messages.TASK_NINE_INPUT_MESSAGE);
        int length = Integer.parseInt(scanner.nextLine());

        System.out.println(bookService.getBookByTitleLengthGreaterThan(length).size());
    }

    private void bookTitlesSearch() {
        System.out.println(Messages.TASK_EIGHT_INTRO_MESSAGE);
        System.out.println(Messages.TASK_EIGHT_INPUT_MESSAGE);
        String name = scanner.nextLine();

        bookService.getBookByAuthorLastNameStartsWith(name).forEach(b -> System.out.printf("%s (%s %s)%n", b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()));
    }

    private void booksSearch() {
        System.out.println(Messages.TASK_SEVEN_INTRO_MESSAGE);
        System.out.println(Messages.TASK_SEVEN_INPUT_MESSAGE);
        String str = scanner.nextLine();

        bookService.getBookByTitleContainingIgnoreCase(str).forEach(b -> System.out.println(b.getTitle()));
    }

    private void authorsSearch() {
        System.out.println(Messages.TASK_SIX_INTRO_MESSAGE);
        System.out.println(Messages.TASK_SIX_INPUT_MESSAGE);
        String partialString = scanner.nextLine();


        authorService.findAuthorByFirstNameEndingWith(partialString).forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    private void booksReleasedBefore() {
        System.out.println(Messages.TASK_FIVE_INTRO_MESSAGE);
        System.out.println(Messages.TASK_FIVE_INPUT_MESSAGE);

        String[] date = scanner.nextLine().split("-");
        int d = Integer.parseInt(date[0]);
        int m = Integer.parseInt(date[1]);
        int y = Integer.parseInt(date[2]);
        LocalDate localDate = LocalDate.of(y, m, d);

        bookService.getBookByReleaseDateBefore(localDate).forEach(b -> System.out.printf(Messages.TASK_FIVE_FORMATTED_OUTPUT, b.getTitle(), b.getEditionType(), b.getPrice()));
    }

    private void notReleasedBooks() {
        System.out.println(Messages.TASK_FOUR_INTRO_MESSAGE);
        System.out.println(Messages.TASK_FOUR_INPUT_MESSAGE);
        String year = scanner.nextLine();


        bookService.getBookByReleaseDateNotContaining(year).forEach(book -> System.out.println(book.getTitle()));
    }

    private void booksByPrice() {
        System.out.println(Messages.TASK_THREE_INTRO_MESSAGE);

        bookService.getBooksWithPriceLowerThanAndHigherThan().forEach(b -> System.out.printf(Messages.TASK_THREE_FORMATTED_OUTPUT, b.getTitle(), b.getPrice()));
    }

    private void goldenBooks() {
        System.out.println(Messages.TASK_TWO_INTRO_MESSAGE);

        bookService.getBookByEditionTypeAndCopiesLessThan().forEach(b -> System.out.println(b.getTitle()));
    }

    private void bookTitlesByAgeRestriction() {
        System.out.println(Messages.TASK_ONE_INTRO_MESSAGE);
        System.out.println(Messages.TASK_ONE_INPUT_MESSAGE);
        String ageRestriction = scanner.nextLine();

        bookService.getBookByAgeRestriction(ageRestriction).forEach(b -> System.out.println(b.getTitle()));
    }

}
