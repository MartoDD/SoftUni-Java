package IteratorsAndComparators.Exercise._1_ListyIterator;

import java.util.Iterator;
import java.util.List;

public class Listiterator implements Iterable<String> {

    private List<String> strings;
    int i=0;

    public Listiterator(List<String> strings) {
        Create(strings);
    }

    public void Create(List<String> strings) {
        this.strings = strings;
    }

    public boolean Move(){
        if (iterator().hasNext()){
            i++;
        }
        return iterator().hasNext();
    }
    public boolean hasNext(){
        return iterator().hasNext();
    }
    public void print() throws Exception {
        if (!strings.isEmpty()){
            System.out.println(strings.get(i));
        }else {
            System.out.println("Invalid Operation!");;
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return i<strings.size();
            }

            @Override
            public String next() {
                return strings.get(i++);
            }
        };
    }
}
