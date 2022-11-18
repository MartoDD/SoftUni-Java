package com.example.bookshopsystem.services.author;

import com.example.bookshopsystem.entities.Author;

import java.time.LocalDate;
import java.util.List;

public interface AuthorService {

    void seedAuthors(List<Author> authors);

    Author getRandomAuthor();
    List<Author>  findDistinctByBooksReleaseDateBefore(LocalDate date);
    Author findAuthorByFirstNameAndLastName(String firstName, String lastName);


}
