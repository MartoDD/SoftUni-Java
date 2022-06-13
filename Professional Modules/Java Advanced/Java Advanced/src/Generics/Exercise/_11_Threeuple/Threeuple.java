package Generics.Exercise._11_Threeuple;

public class Threeuple<T, E, M> {

    private T item1;
    private E item2;
    private M item3;

    public Threeuple(T item1, E item2, M item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return item1 + " -> " + item2 + " -> " + item3;
    }
}
