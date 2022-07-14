package Polymorphism.Lab._2_Shapes;

public class Rectangle extends Shape{

    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }

    @Override
    Double calculatePerimeter() {
        return height*2 + width*2;
    }

    @Override
    Double calculateArea() {
        return height*width;
    }
}
