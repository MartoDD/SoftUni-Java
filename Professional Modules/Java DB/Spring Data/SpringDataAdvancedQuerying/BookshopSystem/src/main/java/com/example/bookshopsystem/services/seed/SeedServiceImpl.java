package com.example.bookshopsystem.services.seed;

import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.entities.Book;
import com.example.bookshopsystem.entities.Category;
import com.example.bookshopsystem.entities.enums.AgeRestriction;
import com.example.bookshopsystem.entities.enums.EditionTypes;
import com.example.bookshopsystem.services.author.AuthorService;
import com.example.bookshopsystem.services.book.BookService;
import com.example.bookshopsystem.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.example.bookshopsystem.Constants.FilePath.*;


@Service
public class SeedServiceImpl implements SeedService {

    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @Autowired
    public SeedServiceImpl(BookService bookService, CategoryService categoryService, AuthorService authorService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @Override
    public void seedAuthors() throws IOException {

        this.authorService.seedAuthors(Files.readAllLines(Path.of(RESOURCE_URL + AUTHORS_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(s -> Author.builder()
                        .firstName(s.split("\\s+")[0])
                        .lastName(s.split("\\s+")[1])
                        .build())
                .collect(Collectors.toList()));
    }

    @Override
    public void seedBooks() throws IOException {

        bookService.seedBooks(Files.readAllLines(Path.of(RESOURCE_URL+BOOKS_FILE_NAME))
                .stream()
                .map(b->{
                    String[] data = b.split("\\s+");
                    String bookTitle= Arrays.stream(data).skip(5).collect(Collectors.joining(" "));

                    return Book.builder()
                            .title(bookTitle)
                            .editionType(EditionTypes.values()[Integer.parseInt(data[0])])
                            .price(new BigDecimal(data[3]))
                            .releaseDate(LocalDate.parse(data[1],DateTimeFormatter.ofPattern("d/M/yyy")))
                            .ageRestriction(AgeRestriction.values()[Integer.parseInt(data[4])])
                            .author(this.authorService.getRandomAuthor())
                            .copies(Integer.parseInt(data[2]))
                            .categories(this.categoryService.getRandomCategory())
                            .build();
                }).collect(Collectors.toList()));

    }

    @Override
    public void seedCategories() throws IOException {

        categoryService.seedCategories(Files.readAllLines(Path.of(RESOURCE_URL + CATEGORIES_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(s -> Category.builder()
                        .name(s)
                        .build())
                .collect(Collectors.toList()));

    }
}
