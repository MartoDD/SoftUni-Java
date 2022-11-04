package com.softuni.bookshop;

import com.softuni.bookshop.entities.Author;
import com.softuni.bookshop.repositories.AuthorRepository;
import com.softuni.bookshop.services.author.AuthorService;
import com.softuni.bookshop.services.book.BookService;
import com.softuni.bookshop.services.seed.SeedService;
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
        // getAllBooksAfterAGivenYear();
        //getAllAuthorsWithBooksBeforeGivenYear();
        getAuthorsByNumberOfBooks();
    }

    public void getAllBooksAfterAGivenYear() {

        LocalDate date = LocalDate.of(2000, 1, 1);

        bookService.findAllByReleaseDateAfter(date).forEach(book -> System.out.println(book.getTitle()));

    }

    public void getAllAuthorsWithBooksBeforeGivenYear() {
        LocalDate date = LocalDate.of(1990, 1, 1);
        authorService.findAuthorByBooksBefore(date).forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    public void getAuthorsByNumberOfBooks() {

        List<Author> authors = authorRepository.findAll();
        authors
                .stream()
                .sorted((l, r) -> r.getBooks().size() - l.getBooks().size())
                .forEach(a -> System.out.printf("%s %s -> %d%n", a.getFirstName(), a.getLastName(), a.getBooks().size()));
    }
}
