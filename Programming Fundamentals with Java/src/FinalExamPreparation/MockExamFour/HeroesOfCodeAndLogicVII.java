package FinalExamPreparation.MockExamFour;

import java.util.*;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Hero> heroes = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] information = scanner.nextLine().split("\\s+");
            String name = information[0];
            int hp = Integer.parseInt(information[1]);
            if (hp > 100) {
                hp = 100;
            }
            int mp = Integer.parseInt(information[2]);
            if (mp > 200) {
                mp = 200;
            }
            Hero hero = new Hero(name, hp, mp);
            heroes.put(name, hero);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split(" - ");
            String heroName = data[1];
            switch (data[0]) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(data[2]);
                    String spellName = data[3];
                    if (heroes.get(heroName).getMp() >= mpNeeded) {
                        heroes.get(heroName).setMp(heroes.get(heroName).getMp() - mpNeeded);
                        System.out.println(heroName + " has successfully cast " + spellName + " and now has " + heroes.get(heroName).getMp() + " MP!");
                    } else {
                        System.out.println(heroName + " does not have enough MP to cast " + spellName + "!");
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(data[2]);
                    String attacker = data[3];
                    if (heroes.get(heroName).getHp() - damage > 0) {
                        heroes.get(heroName).setHp(heroes.get(heroName).getHp() - damage);
                        System.out.println(heroName + " was hit for " + damage + " HP by " + attacker + " and now has " + heroes.get(heroName).getHp() + " HP left!");
                    } else {
                        heroes.remove(heroName);
                        System.out.println(heroName + " has been killed by " + attacker + "!");
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(data[2]);
                    if (heroes.get(heroName).getMp() + amount <= 200) {
                        heroes.get(heroName).setMp(heroes.get(heroName).getMp() + amount);
                        System.out.println(heroName + " recharged for " + amount + " MP!");
                    } else {
                        int toPrint = 200 - heroes.get(heroName).getMp();
                        System.out.println(heroName + " recharged for " + toPrint + " MP!");
                        heroes.get(heroName).setMp(200);
                    }
                    break;
                case "Heal":
                    int quantity = Integer.parseInt(data[2]);
                    if (heroes.get(heroName).getHp() + quantity <= 100) {
                        heroes.get(heroName).setHp(heroes.get(heroName).getHp() + quantity);
                        System.out.println(heroName + " healed for " + quantity + " HP!");
                    } else {
                        int toPrint = 100 - heroes.get(heroName).getHp();
                        System.out.println(heroName + " healed for " + toPrint + " HP!");
                        heroes.get(heroName).setHp(100);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        heroes.forEach((k, v) -> {
            System.out.println(k);
            System.out.println("  HP: " + v.getHp());
            System.out.println("  MP: " + v.getMp());
        });
    }

    static class Hero {
        String name;
        int hp;
        int mp;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getMp() {
            return mp;
        }

        public void setMp(int mp) {
            this.mp = mp;
        }

        public Hero(String name, int hp, int mp) {
            this.name = name;
            this.hp = hp;
            this.mp = mp;
        }

    }
}
