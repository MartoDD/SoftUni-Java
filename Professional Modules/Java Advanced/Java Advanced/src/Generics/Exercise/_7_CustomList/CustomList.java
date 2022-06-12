package Generics.Exercise._7_CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList <T extends Comparable<T>>{

    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element){
        this.list.add(element);
    }

    public T remove(int index){
        T element=list.get(index);
        list.remove(index);
        return element;
    }

    public boolean contains(T element){
        return this.list.contains(element);
    }

    public void swaps(int firstIndex,int secondIndex){
        T temp;
        temp=this.list.get(secondIndex);
        this.list.set(secondIndex,this.list.get(firstIndex));
        this.list.set(firstIndex,temp);
    }

    public int countGreaterThan(T element){
        int count=0;

        for (T t : this.list) {
            if (t.compareTo(element)>0){
                count++;
            }
        }
        return count;
    }

    public T getMin(){
        return this.list.stream().min(T::compareTo).orElse(null);
    }

    public T getMax(){
        return this.list.stream().max(T::compareTo).orElse(null);
    }

    public void print(){
        this.list.forEach(System.out::println);
    }


}
