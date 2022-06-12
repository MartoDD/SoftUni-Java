package Generics.Exercise._4_GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.List;

public class Swapper<T> {

    private List<T> list;

    public Swapper() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public void swap (int firstIndex,int secondIndex){
        T temp;
        temp=this.list.get(secondIndex);
        this.list.set(secondIndex,this.list.get(firstIndex));
        this.list.set(firstIndex,temp);
    }

    public void print(){
        this.list.forEach(e-> System.out.println(this.list.get(0).getClass().getName() + ": " + e));
    }
}
