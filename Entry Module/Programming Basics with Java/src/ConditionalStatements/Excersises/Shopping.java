package ConditionalStatements.Excersises;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = scanner.nextDouble();
        int gpu = scanner.nextInt();
        int cpu = scanner.nextInt();
        int ram = scanner.nextInt();

        int priceGPU = gpu * 250;
        double priceCpu = (priceGPU * 0.35) * cpu;
        double priceRam = (priceGPU * 0.1) * ram;
        double totalPrice = priceCpu + priceGPU + priceRam;

        if (gpu > cpu) {
            totalPrice *= 0.85;
        }
        if (budget >= totalPrice) {
            System.out.printf("You have %.2f leva left!", budget - totalPrice);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", totalPrice - budget);
        }
    }
}
