package IteratorsAndComparators.Exercise._2_Collection;

import java.util.Iterator;
import java.util.List;

public class Listyiterator implements Iterable<String>{

    private List<String> strings;
    int i = 0;

    public Listyiterator(List<String> strings) {
        this.strings= strings;
    }

    public boolean hasNext(){
        return i<strings.size()-1;
    }

    public boolean Move(){
        if (hasNext()){
            i++;
            return true;
        }
        return false;
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
            private int index =0;
            @Override
            public boolean hasNext() {
                return index<strings.size();
            }

            @Override
            public String next() {
                return strings.get(index++);
            }
        };
    }
}
