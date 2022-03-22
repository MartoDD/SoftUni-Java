package ConditionalStatementsAdvanced.MoreExcersises;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hriz = scanner.nextInt();
        int roses = scanner.nextInt();
        int tulips = scanner.nextInt();
        String season = scanner.next();
        String holiday = scanner.next();
        double total=0;


        switch (season){
            case "Spring":
                total= hriz*2.00+roses*4.10+tulips*2.50;

                if (tulips>7){
                    total*=0.95;
                }
                break;
            case "Summer":
                total=hriz*2.00+roses*4.10+tulips*2.50;
                break;
            case "Autumn":
                total=hriz*3.75+roses*4.50+tulips*4.15;
                break;
            case "Winter":
                total=hriz*3.75+roses*4.50+tulips*4.15;
                if (roses>=10){
                    total*=0.90;
                }
                break;
        }
        if (roses+hriz+tulips > 20){
            total*=0.80;
        }
        if (holiday.equals("Y")){
            total*=1.15;
        }
        System.out.printf("%.2f",total+2);
    }
}
