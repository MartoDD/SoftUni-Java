package FinalExamPreparation.MockExamTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantDiscovery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Plant> plants = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] info = scanner.nextLine().split("<->");
            Plant plant = new Plant(info[0], Integer.parseInt(info[1]), new ArrayList<>());
            boolean plantIsPresent = false;
            if (plants.size() == 0) {
                plants.add(plant);
            } else {
                for (Plant plant1 : plants) {
                    if (plant1.getName().equals(plant.getName())) {
                        plant1.setRarity(plant.getRarity());
                        plantIsPresent = true;
                        break;
                    }
                }
                if (!plantIsPresent) {
                    plants.add(plant);
                }
            }

        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] info = input.split("[:\\s-]+");
            boolean isPresent = false;
            switch (info[0]) {
                case "Rate":
                    for (Plant plant : plants) {
                        if (plant.getName().equals(info[1])) {
                            plant.getRating().add(Double.parseDouble(info[2]));
                            isPresent = true;
                            break;
                        }
                    }
                    break;
                case "Update":
                    for (Plant plant : plants) {
                        if (plant.getName().equals(info[1])) {
                            plant.setRarity(Integer.parseInt(info[2]));
                            isPresent = true;
                            break;
                        }
                    }

                    break;
                case "Reset":
                    for (Plant plant : plants) {
                        if (plant.getName().equals(info[1])) {
                            plant.setRating(new ArrayList<>());
                            isPresent = true;
                            break;
                        }
                    }
                    break;
            }
            if (!isPresent) {
                System.out.println("error");
            }

            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");

        for (Plant plant : plants) {
            double avgRating = plant.getRating().stream().mapToDouble(d -> d).average().orElse(0);
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plant.getName(), plant.getRarity(), avgRating);
        }


    }

    static class Plant {
        String name;
        int rarity;
        List<Double> rating;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRarity() {
            return rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public List<Double> getRating() {
            return rating;
        }

        public void setRating(List<Double> rating) {
            this.rating = rating;
        }

        public Plant(String name, int rarity, List<Double> rating) {
            this.name = name;
            this.rarity = rarity;
            this.rating = rating;
        }
    }
}
