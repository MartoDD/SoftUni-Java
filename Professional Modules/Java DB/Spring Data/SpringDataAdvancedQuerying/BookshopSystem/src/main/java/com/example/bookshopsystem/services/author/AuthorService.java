package com.example.bookshopsystem.services.author;

import com.example.bookshopsystem.entities.Author;

import javax.transaction.Transactional;
import java.util.List;

public interface AuthorService {

    void seedAuthors(List<Author> authors);

    Author getRandomAuthor();

    List<Author> findAuthorByFirstNameEndingWith(String str);

    String getAuthorsByBookCount();


    int getCountOfBooksWrittenByAuthor(String name);

}
