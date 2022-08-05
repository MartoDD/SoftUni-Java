package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HouseTests {

    private Cat cat;
    private Cat cat2;
    private Cat cat3;
    private Cat cat4;

    House house = new House("Pesho", 4);

    @Before
    public void setUp() {
        cat = new Cat("Goshko");
        cat2 = new Cat("Toshko");
        cat3 = new Cat("Bojko");
        cat4 = new Cat("Troshko");

        house.addCat(cat);
        house.addCat(cat2);
        house.addCat(cat3);
        house.addCat(cat4);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWithInvalidName() {

        House house = new House(null, 4);
    }

    @Test
    public void testGetName() {

        Assert.assertEquals("Pesho", house.getName());
    }

    @Test
    public void testGetCapacity() {

        Assert.assertEquals(4, house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIncorrectCapacity() {

        House house = new House("Maria", -1);
    }

    @Test
    public void testGetCount() {

        Assert.assertEquals(4, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatWithFullCapacity() {
        house.addCat(new Cat("Mama"));
    }
    @Test
    public void testAddCat(){

        House house1 = new House("Papa",2);

        house1.addCat(cat);

        Assert.assertEquals(1,house1.getCount());

    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveCatWithInvalidName(){
        house.removeCat("Tropa");
    }

    @Test
    public void testRemoveCat(){
        house.removeCat("Troshko");
        Assert.assertEquals(3,house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCatForSaleWithIncorrectName(){

        house.catForSale("Trambala");
    }

    @Test
    public void testCatForSale(){
        Cat testCat= house.catForSale("Goshko");
        Assert.assertEquals(cat,testCat);
        Assert.assertFalse(testCat.isHungry());

    }
    @Test
    public void testGetStatistics(){

    House forTest= new House("Baba",1);
    forTest.addCat(cat);

    Assert.assertEquals("The cat Goshko is in the house Baba!",forTest.statistics());
    }

}
