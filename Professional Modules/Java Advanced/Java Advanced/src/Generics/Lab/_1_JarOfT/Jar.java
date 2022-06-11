package Generics.Lab._1_JarOfT;

import java.util.ArrayDeque;

public class Jar<T> {

    private ArrayDeque<T> deck;

    public Jar() {
        this.deck = new ArrayDeque<>();
    }

    public void add(T element) {

        this.deck.push(element);
    }

    public T remove() {

        return this.deck.pop();
    }
}
