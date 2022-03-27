package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class WeatherForecastPart2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double degree = scanner.nextDouble();

        if (degree >= 26.00 && degree <= 35.00){
            System.out.println("Hot");
        } else if (degree >= 20.1 && degree <= 25.9) {
            System.out.println("Warm");
        }else if (degree >= 15.00 && degree <= 20.00) {
            System.out.println("Mild");
        }else if(degree >=12.00 && degree <= 14.9) {
            System.out.println("Cool");
        }else if (degree >=5.00 && degree <= 11.9){
            System.out.println("Cold");
        }else {
            System.out.println("unknown");
        }
    }
}
