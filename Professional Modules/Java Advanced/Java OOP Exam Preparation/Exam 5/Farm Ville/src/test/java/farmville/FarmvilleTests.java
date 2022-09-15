package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    private Animal animal;
    private Animal animal2;
    private Animal animal3;
    private Animal animal4;

    private Farm farm;

    @Before
    public void setUp() {

        farm = new Farm("Gradus", 4);
        animal = new Animal("Pile", 10);
        animal2 = new Animal("Kokoshka", 13);
        animal3 = new Animal("Petel", 8);
        animal4 = new Animal("Patka", 3);

        farm.add(animal);
        farm.add(animal2);
        farm.add(animal3);
        farm.add(animal4);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(4, farm.getCount());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Gradus", farm.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNoCapacity() {
        Animal animalTest = new Animal("Test", 69);
        farm.add(animalTest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAlreadyExistingAnimal() {
        Animal animalTest = new Animal("Test", 69);
        Farm farmTest = new Farm("TestFarm", 2);
        farmTest.add(animalTest);
        farmTest.add(animalTest);
    }

    @Test
    public void testAddAnimal() {
        Animal animalTest = new Animal("Test", 69);
        Farm farmTest = new Farm("TestFarm", 2);
        farmTest.add(animalTest);
        Assert.assertEquals(1, farmTest.getCount());
    }

    @Test
    public void testRemoveAnimalSuccessfully() {
        Assert.assertTrue(farm.remove("Pile"));
    }

    @Test
    public void testRemoveAnimalThatDoesNotExist() {
        Assert.assertFalse(farm.remove("Mama"));
    }

    @Test
    public void testSetCapacity() {
        Farm farmTest = new Farm("Test", 4);
        Assert.assertEquals(4, farmTest.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidCapacity() {
        Farm farmTest = new Farm("Test", -1);
    }

    @Test
    public void testSetName() {
        Farm farmTest = new Farm("Testing", 4);
        Assert.assertEquals("Testing", farmTest.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetInvalidName() {
        Farm farmTest = new Farm(null, 4);
    }

}
