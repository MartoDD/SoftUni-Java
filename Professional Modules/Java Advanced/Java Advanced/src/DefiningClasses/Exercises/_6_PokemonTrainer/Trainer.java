package DefiningClasses.Exercises._6_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;
    private int collectionBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.collectionBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCollectionBadges() {
        return collectionBadges;
    }

    public void setCollectionBadges(int collectionBadges) {
        this.collectionBadges = collectionBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public boolean hasElement(String element) {
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void applyElement(String element) {
        List<Pokemon> newPokemons=new ArrayList<>();
        if (!hasElement(element)) {
            for (Pokemon pokemon : this.pokemons) {
                if (pokemon.getHealth() - 10 > 0) {
                    pokemon.setHealth(pokemon.getHealth() - 10);
                    newPokemons.add(pokemon);
                }
                this.pokemons=newPokemons;
            }

        } else {
            this.collectionBadges++;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.collectionBadges, this.pokemons.size());
    }
}
