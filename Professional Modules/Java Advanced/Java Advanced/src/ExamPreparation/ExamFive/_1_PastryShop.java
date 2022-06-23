package ExamPreparation.ExamFive;

import java.util.*;
import java.util.stream.Collectors;

public class _1_PastryShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(liquids::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredients::push);

        Map<String, Integer> foods = new LinkedHashMap<>();
        String[] types = {"Biscuit", "Cake", "Pie", "Pastry"};
        Arrays.stream(types).forEach(s -> foods.put(s, 0));

        List<Integer> values = Arrays.asList(25, 50, 75, 100);

        while (liquids.size() != 0 && ingredients.size() != 0) {
            int liquid = liquids.peek();
            int ingredient = ingredients.peek();
            int sum = liquid + ingredient;
            if (values.contains(sum)) {
                extractFood(sum, foods);
                ingredients.pop();
            } else {
                ingredients.push(ingredients.pop() + 3);
            }
            liquids.poll();

        }
        if (checkIfHaveAll(foods)) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        String liquidsToPrint = liquids.size() == 0 ? "none" : liquids.stream().map(Objects::toString).collect(Collectors.joining(", "));
        System.out.println("Liquids left: " + liquidsToPrint);

        String ingredientsToPrint = ingredients.size() == 0 ? "none" : ingredients.stream().map(Objects::toString).collect(Collectors.joining(", "));
        System.out.println("Ingredients left: " + ingredientsToPrint);

        foods.forEach((key, value) -> System.out.println(key + ": " + value));

    }

    private static boolean checkIfHaveAll(Map<String, Integer> foods) {
        for (var entry : foods.entrySet()) {
            if (entry.getValue() == 0) {
                return false;
            }
        }
        return true;

    }

    private static void extractFood(int sum, Map<String, Integer> foods) {
        String food = "";
        switch (sum) {
            case 25:
                food = "Biscuit";
                break;
            case 50:
                food = "Cake";
                break;
            case 75:
                food = "Pastry";
                break;
            case 100:
                food = "Pie";
                break;
        }
        foods.put(food, foods.get(food) + 1);
    }
}
