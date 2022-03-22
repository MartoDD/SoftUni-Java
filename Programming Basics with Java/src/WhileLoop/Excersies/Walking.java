package WhileLoop.Excersies;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int stepSum = 0;


        do {
            String steps = scanner.nextLine();
            if (steps.equals("Going home")) {
                int ha = Integer.parseInt(scanner.nextLine());
                stepSum += ha;
                break;
            }
            int st = Integer.parseInt(steps);
            stepSum += st;
        } while (stepSum < 10000);
        if (stepSum >= 10000) {
            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", stepSum - 10000);
        } else {
            System.out.printf("%d more steps to reach goal.", 10000 - stepSum);
        }

    }
}
