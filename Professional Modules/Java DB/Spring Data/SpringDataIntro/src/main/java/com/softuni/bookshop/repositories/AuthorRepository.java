package com.softuni.bookshop.repositories;

import com.softuni.bookshop.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    Optional<List<Author>> findAuthorByBooksBefore (LocalDate date);




}
