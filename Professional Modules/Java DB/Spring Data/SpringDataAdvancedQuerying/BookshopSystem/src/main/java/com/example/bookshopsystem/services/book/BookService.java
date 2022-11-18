package com.example.bookshopsystem.services.book;

import com.example.bookshopsystem.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    void seedBooks(List<Book> books);

    List<Book> getBookByAgeRestriction(String ageRestriction);

    List<Book>getBookByEditionTypeAndCopiesLessThan();
    List<Book> getBooksWithPriceLowerThanAndHigherThan();

    List<Book>getBookByReleaseDateNotContaining(String year);

    List<Book> getBookByReleaseDateBefore(LocalDate date);

    List<Book> getBookByTitleContainingIgnoreCase(String str);

    List<Book> getBookByAuthorLastNameStartsWith(String start);

    List<Book> getBookByTitleLengthGreaterThan(Integer length);

    List<String> getBookInformationByBookTitle(String title);

    int increaseCopiesOfBooksAfterAGivenDate(LocalDate date,int copies);

    int deleteBookByCopiesLessThan(int number);
}
