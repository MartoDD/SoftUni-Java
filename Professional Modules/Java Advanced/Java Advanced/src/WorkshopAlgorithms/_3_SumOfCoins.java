package WorkshopAlgorithms;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _3_SumOfCoins {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] coins=Arrays.stream(scanner.nextLine().split(": ")[1].split(", ")).mapToInt(Integer::parseInt).toArray();
        int sum=Integer.parseInt(scanner.nextLine().split(": ")[1]);

        Map<Integer,Integer> countedCoins=new LinkedHashMap<>();
        for (int i = coins.length-1; i >=0; i--) {
            int coin = coins[i];
            int count = sum / coin;
            countedCoins.put(coin, count);
            sum = sum % coin;

        }
        if (sum>0){
            System.out.println("Error");
        }else {
            int totalCoins = countedCoins.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("Number of coins to take: " + totalCoins);
            countedCoins.entrySet().stream().filter(e->e.getValue()!=0).
                    forEach(entry-> System.out.printf("%d coin(s) with value %d%n",entry.getValue(),entry.getKey()));
        }


    }
}
