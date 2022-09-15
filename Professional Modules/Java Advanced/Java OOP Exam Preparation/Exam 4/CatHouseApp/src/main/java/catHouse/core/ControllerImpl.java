package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;

        if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        } else if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;

        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        if (toys.findFirst(toyType) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }
        Toy toy = toys.findFirst(toyType);
        toys.removeToy(toy);
        houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().get().buyToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {

        Cat cat;

        if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }

        House house = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);

        assert house != null;
        if ((house.getClass().getSimpleName().equals("LongHouse") && catType.equals("ShorthairCat")) || house.getClass().getSimpleName().equals("ShortHouse") && catType.equals("LonghairCat")) {
            return ConstantMessages.UNSUITABLE_HOUSE;
        }

        houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().get().addCat(cat);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {

        houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().get().getCats().forEach(Cat::eating);

        int numberOfCats = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().get().getCats().size();

        return String.format(ConstantMessages.FEEDING_CAT, numberOfCats);
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);

        assert house != null;
        double total = house.getCats().stream().mapToDouble(Cat::getPrice).sum() + house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        return String.format(ConstantMessages.VALUE_HOUSE, houseName, total);
    }

    @Override
    public String getStatistics() {
        return houses.stream().map(House::getStatistics)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
