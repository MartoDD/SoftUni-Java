package Exam;

import java.util.*;

public class _1_ItsChocolateTime {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milk = new ArrayDeque<>();
        ArrayDeque<Double> cacao = new ArrayDeque<>();
        Map<String, Integer> chocolates = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).forEach(milk::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).forEach(cacao::push);

        while (cacao.size() > 0 && milk.size() > 0) {
            double mil = milk.peek();
            double coco = cacao.peek();

            double sumOfBoth = mil + coco;
            double percentage = (coco / sumOfBoth) * 100;
            if (checkForChocolate(percentage, chocolates)){
                milk.poll();
                cacao.pop();
            }else {
                cacao.pop();
                if (milk.size()!=0){
                    milk.offer(milk.poll()+10);
                }
            }
        }

        if (chocolates.size()==3){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        chocolates.forEach((k,v)-> System.out.println("# " + k + " --> " + v));
    }

    private static boolean checkForChocolate(double percentage, Map<String, Integer> chocolates) {
        int perc = (int) Math.ceil(percentage);
        String choco;
        switch (perc) {
            case 30:
                choco = "Milk Chocolate";
                chocolates.putIfAbsent(choco,0);
                chocolates.put(choco,chocolates.get(choco)+1);
                return true;
            case 50:
                choco = "Dark Chocolate";
                chocolates.putIfAbsent(choco,0);
                chocolates.put(choco,chocolates.get(choco)+1);
                return true;
            case 100:
                choco = "Baking Chocolate";
                chocolates.putIfAbsent(choco,0);
                chocolates.put(choco,chocolates.get(choco)+1);
                return true;
        }
        return false;
    }
}
