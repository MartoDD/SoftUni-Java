package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PetStoreTests {

    private static final int ANIMAL_COUNT = 5;
    private static final int MAX_ANIMAL_KG = 26;
    private static final String SPECIES = "Dog";

    PetStore petStore = new PetStore();
    Animal animal = null;
    Animal animal1 = null;
    Animal animal2 = null;
    Animal animal3 = null;
    Animal animal4 = null;

    @Before
    public void setUp() {


        animal = new Animal("Cat", 30, 250.15);
        animal1 = new Animal("Dog", 25, 150.5);
        animal2 = new Animal("Parrot", 12, 125.15);
        animal3 = new Animal("Snake", 28, 350.15);
        animal4 = new Animal("Monkey", 10, 650.45);

        petStore.addAnimal(animal);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);

    }


    @Test
    public void testAnimalCount() {
        Assert.assertEquals(ANIMAL_COUNT, petStore.getCount());
    }

    @Test
    public void testFindAnimalWithMaxWeight() {

        List<Animal> expected = new ArrayList<>();
        expected.add(animal);
        expected.add(animal3);

        List<Animal> actual = petStore.findAllAnimalsWithMaxKilograms(MAX_ANIMAL_KG);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWithException() {
        petStore.addAnimal(null);
    }
    @Test
    public void testGetAnimals(){
        List<Animal> expected= new ArrayList<>();
        expected.add(animal);
        expected.add(animal1);
        expected.add(animal2);
        expected.add(animal3);
        expected.add(animal4);

        Assert.assertEquals(expected,petStore.getAnimals());
    }

    @Test
    public void testAddAnimalWithoutException() {

        List<Animal> expected = new ArrayList<>();
        expected.add(animal);
        PetStore petShop = new PetStore();
        petShop.addAnimal(animal);

        Assert.assertEquals(expected, petShop.getAnimals());
    }

    @Test
    public void testGetTheMostExpensiveAnimal() {

        Assert.assertEquals(animal4, petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void testFindAnimalBySpecies() {
        List<Animal> expected = new ArrayList<>();
        expected.add(animal1);

        List<Animal> actual = petStore.findAllAnimalBySpecie(SPECIES);
        Assert.assertEquals(expected, actual);
    }
}

