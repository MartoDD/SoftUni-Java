package IteratorsAndComparators.Exercise._3_StackIterator;

import java.util.Iterator;

public class Stack implements Iterable<Integer>{

    public static Node top;

    Node head;
    int size;


    public void push(int value) {
        if (this.size == 0) {
            head = new Node(value);
            top = head;
        } else {
            top.setNext(new Node(value));
            top.getNext().setPrev(top);
            top = top.getNext();
        }
        size++;

    }

    public void pop() {
        if (size==0){
            top=null;
            System.out.println("No elements");

        }else if (size==1){
            top=null;
        } else if (size>1){
            top = top.getPrev();
        }
        size--;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
           private Node current=top;
            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public Integer next() {
                int value=current.getValue();
                current=current.getPrev();
                return value;
            }
        };
    }
}
