package WorkingWithAbstractions.Lab._2_PointInRectangle;

public class Rectangle {

    private Point bottomLeft;
    private Point topRight;

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public boolean contains(Point point){
        return point.getY()>=bottomLeft.getY() && point.getY()<=topRight.getY() && point.getX()>=bottomLeft.getX() && point.getX()<=topRight.getX();
    }
}
