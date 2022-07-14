package Polymorphism.Lab._2_Shapes;

public class Circle extends Shape{

    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    Double calculatePerimeter() {
        return 2* Math.PI * radius;
    }

    @Override
    Double calculateArea() {
        return Math.PI*radius*radius;
    }
}
