package FinalExamPreparation.MockExamFive;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, City> cities = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Sail")) {
            String[] data = input.split("[|]{2}");
            City city = new City(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            if (!cities.containsKey(data[0])) {
                cities.put(data[0], city);
            } else {
                cities.get(data[0]).setGold(cities.get(data[0]).getGold() + Integer.parseInt(data[2]));
                cities.get(data[0]).setPopulation(cities.get(data[0]).getPopulation() + Integer.parseInt(data[1]));
            }

            input = scanner.nextLine();
        }
        String in = scanner.nextLine();

        while (!in.equals("End")) {
            String[] instructions = in.split("=>");
            String town;
            int people;
            int gold;
            switch (instructions[0]) {
                case "Plunder":
                    town = instructions[1];
                    people = Integer.parseInt(instructions[2]);
                    gold = Integer.parseInt(instructions[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                    cities.get(town).setPopulation(cities.get(town).getPopulation() - people);
                    cities.get(town).setGold(cities.get(town).getGold() - gold);
                    if (cities.get(town).getGold() == 0 || cities.get(town).getPopulation() == 0) {
                        cities.remove(town);
                        System.out.println(town + " has been wiped off the map!");
                    }
                    break;
                case "Prosper":
                    town = instructions[1];
                    gold = Integer.parseInt(instructions[2]);
                    if (gold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        cities.get(town).setGold(cities.get(town).getGold() + gold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, cities.get(town).getGold());
                    }
                    break;
            }

            in = scanner.nextLine();
        }
        if (cities.size() == 0) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.println("Ahoy, Captain! There are " + cities.size() + " wealthy settlements to go to:");
            cities.forEach((key, value) -> {
                System.out.print(key + " -> ");
                System.out.printf("Population: %d citizens, Gold: %d kg%n", value.getPopulation(), value.getGold());
            });
        }


    }

    static class City {
        String name;
        int population;
        int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public String print() {
            return String.format("Population: %d citizens, Gold: %d kg%n", this.population, this.gold);
        }
    }
}
