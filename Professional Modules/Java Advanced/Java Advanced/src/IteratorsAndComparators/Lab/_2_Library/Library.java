package IteratorsAndComparators.Lab._2_Library;

import java.util.Iterator;

public class Library implements Iterable<Book>{
    private Book[] books;

    public Library(Book...books){
        this.books=books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new Iterator<Book>() {
            int i=0;
            @Override
            public boolean hasNext() {
                return i<books.length;
            }

            @Override
            public Book next() {
                return books[i++];
            }
        };
    }
}
