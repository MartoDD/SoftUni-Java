package com.example.bookshopsystem.services.author;

import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
    public List<Author> findAuthorByFirstNameEndingWith(String str) {
        return authorRepository.findAuthorByFirstNameEndingWith(str);
    }

    @Override
    public String getAuthorsByBookCount() {
      return  authorRepository.getAuthorsByBookCount().stream()
              .map(s->{
                  String[]info=s.split(",");
                  return String.format("%s %s - %s",info[0],info[1],info[2]);
              }).collect(Collectors.joining(System.lineSeparator()));

    }

    @Override
    @Transactional
    public int getCountOfBooksWrittenByAuthor(String name) {
        return authorRepository.getCountOfBooksWrittenBy(name);
    }


}
