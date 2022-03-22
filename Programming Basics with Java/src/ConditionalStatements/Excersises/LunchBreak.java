package ConditionalStatements.Excersises;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nameOfShow = scanner.nextLine();
        double episodeLength = scanner.nextDouble();
        double breakLength = scanner.nextDouble();

        double lunchTime = breakLength / 8;
        double restTime = breakLength / 4;
        double remainingBreak = breakLength - lunchTime - restTime;

        if (remainingBreak >= episodeLength) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", nameOfShow, Math.ceil(remainingBreak - episodeLength));

        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", nameOfShow, Math.ceil(episodeLength - remainingBreak));
        }
    }
}
