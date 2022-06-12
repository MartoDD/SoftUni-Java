package Generics.Exercise._2_GenericBoxOfInteger;

public class Box<T> {

    private T box;

    public Box(T box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return this.box.getClass().getName() + ": " + this.box;
    }
}
