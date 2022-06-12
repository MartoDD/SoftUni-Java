package Generics.Exercise._5_GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>>{

    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {

        this.list.add(element);
    }

    public int returnCompared(T element){
        int occurrences=0;

        for (T t : list) {
            if (t.compareTo(element)>0){
                occurrences++;
            }
        }
        return occurrences;
    }
}
