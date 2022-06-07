package DefiningClasses.Exercises._6_PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {

            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            Trainer trainer = new Trainer(trainerName);
            trainer.getPokemons().add(pokemon);
            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, trainer);
            } else {
                trainers.get(trainerName).getPokemons().add(pokemon);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {

            for (var entry : trainers.entrySet()) {
                entry.getValue().applyElement(input);
            }

            input = scanner.nextLine();
        }

        trainers.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().getCollectionBadges(), e1.getValue().getCollectionBadges())).forEach(entry -> System.out.println(entry.getValue()));

    }
}
