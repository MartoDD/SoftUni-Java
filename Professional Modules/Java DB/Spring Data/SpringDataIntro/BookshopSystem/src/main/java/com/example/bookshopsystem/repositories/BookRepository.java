package com.example.bookshopsystem.repositories;

import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Optional<List<Book>> findAllByReleaseDateAfter(LocalDate date);
    List<Book> findAllByAuthorOrderByReleaseDateDescTitle(Author author);
}
