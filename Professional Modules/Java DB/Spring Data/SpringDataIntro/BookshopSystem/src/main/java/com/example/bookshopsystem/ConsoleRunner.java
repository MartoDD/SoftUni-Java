package com.example.bookshopsystem;

import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.entities.Book;
import com.example.bookshopsystem.repositories.AuthorRepository;
import com.example.bookshopsystem.services.author.AuthorService;
import com.example.bookshopsystem.services.book.BookService;
import com.example.bookshopsystem.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookService bookService;

    private final AuthorService authorService;
    private final AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService, AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }


    @Override
    public void run(String... args) throws Exception {
       // seedService.seedAll();
        //getAllBooksAfterAGivenYear();
        //getAllAuthorsWithBooksBeforeGivenYear();
        // getAuthorsByNumberOfBooks();
        //getAllBooksByAuthor();
    }

    public void getAllBooksAfterAGivenYear() {

        LocalDate date = LocalDate.of(2000, 1, 1);

        bookService.findAllByReleaseDateAfter(date).forEach(book -> System.out.println(book.getTitle()));

    }

    public void getAllAuthorsWithBooksBeforeGivenYear() {
        LocalDate date = LocalDate.of(1990, 1, 1);
        authorService.findDistinctByBooksReleaseDateBefore(date).forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    public void getAuthorsByNumberOfBooks() {

        List<Author> authors = authorRepository.findAll();
        authors.stream()
                .sorted((a1, a2) -> Integer.compare(a2.getBooks().size(), a1.getBooks().size()))
                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));

    }

    public void getAllBooksByAuthor(){
        Author authorInQuestion = authorRepository.findAuthorByFirstNameAndLastName("George","Powell");
        List<Book> books = bookService.findAllByAuthorOrderByReleaseDateDescTitle(authorInQuestion);
        String printBookInfo="Title: %s%n Release date: %s%n Number of copies: %d%n";
        books.forEach(book-> System.out.printf(printBookInfo, book.getTitle(), book.getReleaseDate(), book.getCopies()));


    }
}
