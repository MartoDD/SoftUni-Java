package IteratorsAndComparators.Lab._4_BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int i =o1.getTitle().compareTo(o2.getTitle());
        if (i==0){
            i=Integer.compare(o1.getYear(),o2.getYear());
        }
        return i;
    }
}
