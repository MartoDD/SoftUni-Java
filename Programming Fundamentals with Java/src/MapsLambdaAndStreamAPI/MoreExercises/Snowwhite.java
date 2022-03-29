package MapsLambdaAndStreamAPI.MoreExercises;

import java.util.*;

public class Snowwhite {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Dwarf>> dwarves = new LinkedHashMap<>();

        while (!input.equals("Once upon a time")) {
            String[] data = input.split(" <:> ");
            String name = data[0];
            String color = data[1];
            int physics = Integer.parseInt(data[2]);
            boolean dwarfIsPresent = false;
            if (!dwarves.containsKey(color)){
                dwarves.putIfAbsent(color,new ArrayList<>());
                dwarves.get(color).add(new Dwarf(name,physics));
            }else {
                for (Dwarf dwarf : dwarves.get(color)) {
                    if (dwarf.getName().equals(name)){
                        dwarfIsPresent=true;
                        if (dwarf.getPhysics()<physics){
                            dwarf.setPhysics(physics);
                            break;
                        }
                    }
                }
                if (!dwarfIsPresent){
                    dwarves.get(color).add(new Dwarf(name,physics));
                }

            }

            input = scanner.nextLine();
        }

        dwarves.entrySet()
                .stream()
                .sorted((d1, d2) -> {
                    int result = Integer.compare(d2.getValue().stream().mapToInt(Dwarf::getPhysics).sum(), d1.getValue().stream().mapToInt(Dwarf::getPhysics).sum());
                    if (result == 0) {
                        result = Integer.compare(d1.getValue().size(), d2.getValue().size());
                    }
                    return result;
                }).forEach(stringListEntry -> stringListEntry.getValue().forEach(dwarf -> System.out.printf("(%s) %s <-> %d%n", stringListEntry.getKey(), dwarf.getName(), dwarf.getPhysics())));


    }

    static class Dwarf {
        String name;
        int physics;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPhysics() {
            return physics;
        }

        public void setPhysics(int physics) {
            this.physics = physics;
        }

        public Dwarf(String name, int physics) {
            this.name = name;
            this.physics = physics;
        }
    }
}
