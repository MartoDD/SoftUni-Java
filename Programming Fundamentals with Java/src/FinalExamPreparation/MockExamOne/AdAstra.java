package FinalExamPreparation.MockExamOne;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String regEx = "([#|])(?<item>[A-Za-z\\s]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);
        int sumCalories = 0;
        List<Item> items = new ArrayList<>();

        while (matcher.find()) {
            int calories = Integer.parseInt(matcher.group("calories"));
            if (calories <= 10000 && calories >= 0) {
                sumCalories += calories;
            }
            String name = matcher.group("item");
            String date = matcher.group("date");
            Item item = new Item(name, date, calories);
            items.add(item);
        }
        int totalDays = sumCalories / 2000;

        System.out.println("You have food to last you for: " + totalDays + " days!");
        for (Item item : items) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n", item.getName(), item.getDate(), item.getNutrition());
        }


    }

    static class Item {
        String name;
        String date;
        Integer nutrition;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Integer getNutrition() {
            return nutrition;
        }

        public void setNutrition(Integer nutrition) {
            this.nutrition = nutrition;
        }

        public Item(String name, String date, Integer nutrition) {
            this.name = name;
            this.date = date;
            this.nutrition = nutrition;
        }
    }
}
