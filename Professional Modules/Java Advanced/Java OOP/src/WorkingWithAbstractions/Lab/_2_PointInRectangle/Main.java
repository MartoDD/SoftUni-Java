package WorkingWithAbstractions.Lab._2_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int [] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Point bottomLeft=new Point(coordinates[0],coordinates[1]);
        Point topRight = new Point(coordinates[2],coordinates[3]);

        Rectangle rectangle = new Rectangle();
        rectangle.setBottomLeft(bottomLeft);
        rectangle.setTopRight(topRight);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int [] point = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Point point1 = new Point(point[0],point[1]);

            System.out.println(rectangle.contains(point1));
        }
    }
}
