package ExamPreparation.ExamFour;

import java.util.*;

public class _1_AutumnCocktails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshness = new ArrayDeque<>();


        List<Integer> values = new ArrayList<>();
        values.add(150);
        values.add(250);
        values.add(300);
        values.add(400);


        Map<String, Integer> cocktails = new TreeMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredients::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(freshness::push);

        while (ingredients.size() > 0 && freshness.size() > 0) {
            int ingredient = ingredients.peek();
            int freshnes = freshness.peek();

            if (ingredient==0){
                ingredients.poll();
                continue;

            }
            int value = ingredient * freshnes;
            if (values.contains(value)) {
                extractDrink(value, cocktails);
                ingredients.poll();
                freshness.pop();
            } else {
                freshness.pop();
                if (ingredients.size()>0){
                    ingredients.offer(ingredients.poll() + 5);
                }

            }


        }
        if (cocktails.size()==4){
            System.out.println("It's party time! The cocktails are ready!");
        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (ingredients.size()!=0){
            System.out.println("Ingredients left: " + ingredients.stream().mapToInt(integer -> integer).sum());
        }
        cocktails.forEach((k,v)-> System.out.println("# " + k + " --> " + v));

    }

    private static void extractDrink(int value, Map<String, Integer> cocktails) {
       String name="";
        switch (value) {
            case 150:
                 name="Pear Sour";
                break;
            case 250:
                name="The Harvest";
                break;
            case 300:
                name="Apple Hinny";
                break;
            case 400:
                name="High Fashion";
                break;
        }
        cocktails.putIfAbsent(name,0);
        cocktails.put(name,cocktails.get(name)+1);
    }
}
