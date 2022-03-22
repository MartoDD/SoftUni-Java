package FirstStepsInCoding.Excersises;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        int volume = length * width * height;
        double volumeLt = volume * 0.001;
        double totalVolume = volumeLt - (volumeLt * (percent/100));
        System.out.println(totalVolume);
    }
}
