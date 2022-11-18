package com.example.bookshopsystem.services.author;

import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.repositories.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors(List<Author> authors) {

        this.authorRepository.saveAll(authors);

    }

    @Override
    public Author getRandomAuthor() {

        Random random = new Random();
        int randomNumber = random.nextInt(0,(int)this.authorRepository.count()) + 1;
        return this.authorRepository.findById(randomNumber).orElse(null);
    }

    @Override
    public List<Author> findDistinctByBooksReleaseDateBefore(LocalDate date) {
        return authorRepository. findDistinctByBooksReleaseDateBefore(date).orElseThrow();
    }

    @Override
    public Author findAuthorByFirstNameAndLastName(String firstName, String lastName) {
        return authorRepository.findAuthorByFirstNameAndLastName(firstName,lastName);
    }


}
