package com.softuni.bookshop.services.author;

import com.softuni.bookshop.entities.Author;
import com.softuni.bookshop.repositories.AuthorRepository;
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
    public List<Author> findAuthorByBooksBefore(LocalDate date) {
        return authorRepository.findAuthorByBooksBefore(date).orElseThrow();
    }


}
