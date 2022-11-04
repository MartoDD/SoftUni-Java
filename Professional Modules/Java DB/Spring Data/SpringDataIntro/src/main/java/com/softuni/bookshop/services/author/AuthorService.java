package com.softuni.bookshop.services.author;

import com.softuni.bookshop.entities.Author;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AuthorService {

    void seedAuthors(List<Author> authors);

    Author getRandomAuthor();
    List<Author> findAuthorByBooksBefore(LocalDate date);


}
