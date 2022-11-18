package com.example.bookshopsystem.services.book;

import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    void seedBooks(List<Book> books);

    List<Book> findAllByReleaseDateAfter(LocalDate date);
    List<Book> findAllByAuthorOrderByReleaseDateDescTitle (Author author);
}
