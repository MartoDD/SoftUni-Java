package Polymorphism.Lab._2_Shapes;

public abstract class Shape {

    private  Double perimeter;
    private Double area;

    abstract Double calculatePerimeter();
    abstract Double calculateArea();

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }
}
