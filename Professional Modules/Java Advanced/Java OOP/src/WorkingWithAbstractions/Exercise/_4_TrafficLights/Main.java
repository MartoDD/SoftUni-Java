package WorkingWithAbstractions.Exercise._4_TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] lights = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String light : lights) {

            Color color = Color.valueOf(light);
            TrafficLight trafficLight = new TrafficLight(color);
            trafficLights.add(trafficLight);

        }

        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.switchColor();
                System.out.print(trafficLight + " ");
            }
            System.out.println();

        }


    }
}
