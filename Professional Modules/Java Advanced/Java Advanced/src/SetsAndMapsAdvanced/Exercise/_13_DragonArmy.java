package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _13_DragonArmy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Dragon>> dragons = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String type = data[0];
            String name = data[1];
            int damage;
            if (!data[2].equals("null")) {
                damage = Integer.parseInt(data[2]);
            } else {
                damage = 45;
            }
            int health;
            if (!data[3].equals("null")) {
                health = Integer.parseInt(data[3]);
            } else {
                health = 250;
            }
            int armor;
            if (!data[4].equals("null")) {
                armor = Integer.parseInt(data[4]);
            } else {
                armor = 10;
            }
            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).put(name, new Dragon(name, damage, health, armor));

        }

        dragons.forEach((k, v) -> {
            double avgDmg = v.values().stream().mapToDouble(Dragon::getDamage).average().orElse(0);
            double avgHealth = v.values().stream().mapToDouble(Dragon::getHealth).average().orElse(0);
            double avgArmor = v.values().stream().mapToDouble(Dragon::getArmor).average().orElse(0);

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", k, avgDmg, avgHealth, avgArmor);
            v.forEach((s, dragons1) -> System.out.println("-" + s + " -> " + dragons1.print()));
        });
    }

    static class Dragon {
        String name;
        int damage;
        int health;
        int armor;

        public Dragon(String name, int damage, int health, int armor) {
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }

        String print() {
            return String.format("damage: %d, health: %d, armor: %d", this.damage, this.health, this.armor);

        }
    }
}
