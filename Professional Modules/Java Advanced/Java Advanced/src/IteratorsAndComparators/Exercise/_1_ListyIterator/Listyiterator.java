package IteratorsAndComparators.Exercise._1_ListyIterator;

import java.util.Arrays;
import java.util.List;

public class Listyiterator{

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

}
