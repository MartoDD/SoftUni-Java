package IteratorsAndComparators.Exercise._9_LinkedListTraversal;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E>{

    private Node<E> head;
    private Node<E> tail;
    private Node<E> previous;
    private int size;

    public LinkedList() {
        this.size = 0;
        this.head = null;
        this.previous = null;
        this.tail = null;
    }

    public void add(E number) {
        if (size == 0) {
            head = new Node<E>(number);
            tail = head;
        } else {
            Node<E> node = new Node<E>(number);
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public void remove(E number) {
        Node<E> currentNode=head;

        while (currentNode!=null){
            if (currentNode.getValue()==number){
                if (currentNode==head){
                    head=currentNode.getNext();
                }else {
                    currentNode.getPrevious().setNext(currentNode.getNext());
                    currentNode.getNext().setPrevious(currentNode.getPrevious());
                }
                size--;
                return;
            }
            currentNode=currentNode.getNext();
        }
    }
    public int getSize(){
        return size;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current=head;
            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public E next() {
                E toReturn=current.getValue();
                current=current.getNext();
                return toReturn;
            }
        };
    }
}
