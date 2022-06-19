package IteratorsAndComparators.Exercise._9_LinkedListTraversal;

public class Node<E> {

    private E value;
    private Node<E> next;
    private Node<E> previous;

    public Node(E value) {
        this.value = value;
        this.next=null;
        this.previous=null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

}
