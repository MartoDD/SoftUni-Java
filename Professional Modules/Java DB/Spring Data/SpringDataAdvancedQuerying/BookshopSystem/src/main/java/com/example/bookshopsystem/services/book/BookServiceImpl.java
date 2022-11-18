package com.example.bookshopsystem.services.book;

import com.example.bookshopsystem.Constants.Values;
import com.example.bookshopsystem.entities.Book;
import com.example.bookshopsystem.entities.enums.AgeRestriction;
import com.example.bookshopsystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{


    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedBooks(List<Book> books) {

        this.bookRepository.saveAll(books);

    }

    @Override
    public List<Book> getBookByAgeRestriction(String ageRestriction) {

        AgeRestriction castedAgeRestriction=AgeRestriction.valueOf(ageRestriction.toUpperCase());

        return bookRepository.getBookByAgeRestriction(castedAgeRestriction);
    }

    @Override
    public List<Book> getBookByEditionTypeAndCopiesLessThan() {
        return bookRepository.getBookByEditionTypeAndCopiesLessThan(Values.EDITION_TYPE, Values.NUMBER_OF_COPIES);
    }


    @Override
    public List<Book> getBooksWithPriceLowerThanAndHigherThan() {
        return bookRepository.getBooksByPriceLessThanOrPriceGreaterThan(Values.LOWER_PRICE,Values.UPPER_PRICE);
    }

    @Override
    public List<Book> getBookByReleaseDateNotContaining(String year) {
        return bookRepository.getBookByReleaseDateYearNot(year);
    }

    @Override
    public List<Book> getBookByReleaseDateBefore(LocalDate date) {
        return bookRepository.getBookByReleaseDateBefore(date);
    }

    @Override
    public List<Book> getBookByTitleContainingIgnoreCase(String str) {
        return bookRepository.getBookByTitleContainingIgnoreCase(str);
    }

    @Override
    public List<Book> getBookByAuthorLastNameStartsWith(String start) {
        return bookRepository.getBookByAuthorLastNameStartsWith(start);
    }

    @Override
    public List<Book> getBookByTitleLengthGreaterThan(Integer length) {
        return bookRepository.getBookByTitleLengthGreaterThan(length);
    }

    @Override
    public List<String> getBookInformationByBookTitle(String title) {
        return bookRepository.getBookInformationByBookTitle(title)
                .stream().map(s->s.replace(',',' ')).collect(Collectors.toList());
    }

    @Override
    public int increaseCopiesOfBooksAfterAGivenDate(LocalDate date, int copies) {
        return bookRepository.increaseCopiesOfBooksAfterAGivenDate(date,copies);
    }

    @Override
    public int deleteBookByCopiesLessThan(int number) {
        return bookRepository.deleteBookByCopiesLessThan(number);
    }

}
