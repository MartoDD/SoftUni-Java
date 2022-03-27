package ForLoop.MoreExcersises;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double inheritMoney = scanner.nextDouble();
        double year = scanner.nextDouble();
        double expenses = 0;
        int age = 17;

        for (int i = 1800; i <= year; i++) {
            age++;
            if (i % 2 == 0) {
                expenses += 12000;
            } else {
                expenses += 12000 + 50 * age;
            }
        }
        if (expenses > inheritMoney) {
            System.out.printf("He will need %.2f dollars to survive.", expenses - inheritMoney);
        } else {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", inheritMoney - expenses);
        }
    }
}
