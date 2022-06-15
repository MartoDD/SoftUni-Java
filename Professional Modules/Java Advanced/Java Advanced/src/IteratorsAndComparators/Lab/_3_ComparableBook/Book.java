package IteratorsAndComparators.Lab._3_ComparableBook;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... strings) {
        setTitle(title);
        setYear(year);
        setAuthors(strings);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... strings) {
        this.authors = Arrays.asList(strings);
    }

    @Override
    public int compareTo(Book other) {
        int i =this.title.compareTo(other.title);
        if (i==0){
            i=Integer.compare(this.year,other.year);
        }
        return i;
    }
}
