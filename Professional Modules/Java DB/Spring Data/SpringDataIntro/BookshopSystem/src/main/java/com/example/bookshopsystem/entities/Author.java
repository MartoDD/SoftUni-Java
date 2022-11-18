package com.example.bookshopsystem.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @OneToMany(targetEntity = Book.class,mappedBy = "author",fetch = FetchType.EAGER)
    private Set<Book> books;

    public Author() {
        books=new HashSet<>();
    }

    public Author(String firstName, String lastName) {
        this();

        this.firstName = firstName;
        this.lastName = lastName;

    }
}
