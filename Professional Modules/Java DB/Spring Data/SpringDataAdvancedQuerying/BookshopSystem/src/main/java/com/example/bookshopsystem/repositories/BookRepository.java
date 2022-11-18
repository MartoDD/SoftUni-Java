package com.example.bookshopsystem.repositories;

import com.example.bookshopsystem.entities.Book;
import com.example.bookshopsystem.entities.enums.AgeRestriction;
import com.example.bookshopsystem.entities.enums.EditionTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


   List<Book>getBookByAgeRestriction(AgeRestriction ageRestriction);
   List<Book>getBookByEditionTypeAndCopiesLessThan(EditionTypes editionType,Integer copies);

   List<Book>getBooksByPriceLessThanOrPriceGreaterThan(BigDecimal lower,BigDecimal upper);

   @Query("SELECT b FROM Book AS b WHERE SUBSTRING(b.releaseDate,1,4) NOT LIKE :year")
   List<Book> getBookByReleaseDateYearNot (String year);

   List<Book> getBookByReleaseDateBefore(LocalDate date);

   List<Book> getBookByTitleContainingIgnoreCase(String str);

   @Query("SELECT b FROM Book AS b WHERE b.author.lastName LIKE :start%")
   List<Book> getBookByAuthorLastNameStartsWith(String start);

   @Query("SELECT b FROM Book AS b WHERE length(b.title)> :length ")
   List<Book> getBookByTitleLengthGreaterThan(Integer length);

   @Query("SELECT b.title,b.editionType,b.ageRestriction,b.price FROM Book AS b WHERE b.title LIKE :title")
   List<String> getBookInformationByBookTitle(String title);

   @Modifying
   @Transactional
   @Query("update Book AS b SET b.copies=b.copies+:copies WHERE b.releaseDate>:date")
   int increaseCopiesOfBooksAfterAGivenDate(LocalDate date,int copies);

   @Transactional
   int deleteBookByCopiesLessThan(int number);


}
