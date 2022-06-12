package Generics.Exercise._1_GenericBox;

public class Box <T>{

    private T box;

    public Box(T box) {
        this.box = box;
    }

    public T getBox() {
        return box;
    }

    public void setBox(T box) {
        this.box = box;
    }

    @Override
    public String toString(){
        return this.box.getClass().getName() + ": " + this.box;
    }
}
