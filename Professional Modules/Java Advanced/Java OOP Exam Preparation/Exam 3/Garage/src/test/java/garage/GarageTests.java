package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GarageTests {

    Car car;
    Car car2;
    Car car3;
    Car car4;

    Garage garage = new Garage();

    @Before
    public void setUp() {
        car = new Car("Porche", 123, 540);
        car2 = new Car("Ferari", 321, 345);
        car3 = new Car("Opel", 10, 124);
        car4 = new Car("KIA", 500, 200);

        garage.addCar(car);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.addCar(car4);
    }

    @Test
    public void testGetCont() {
        Assert.assertEquals(4, garage.getCount());
    }

    @Test
    public void testGetCars() {
        Collection<Car> expected=new ArrayList<>();
        expected.add(car);
        expected.add(car2);
        expected.add(car3);
        expected.add(car4);

        Assert.assertEquals(expected,garage.getCars());
    }
    @Test
public void testGetAllCarsWithSpeedGreaterThanProvided(){

        List<Car> expected = new ArrayList<>();
        expected.add(car4);

        Assert.assertEquals(expected,garage.findAllCarsWithMaxSpeedAbove(400));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullCar(){
        garage.addCar(null);
    }
    @Test
    public void testGetTheMostExpensiveCar(){
        Assert.assertEquals(car,garage.getTheMostExpensiveCar());
    }
    @Test
    public void testFindAllCarsByBrand(){
        List<Car> expected=new ArrayList<>();

        expected.add(car4);

        Assert.assertEquals(expected,garage.findAllCarsByBrand("KIA"));
    }
}