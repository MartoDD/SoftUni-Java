package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private FoodRepositoryImpl foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        if (!areaType.equals("WaterArea") && !areaType.equals("LandArea")) {
            throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }
        if (areaType.equals("WaterArea")) {
            WaterArea waterArea = new WaterArea(areaName);
            areas.add(waterArea);
        } else {
            LandArea landArea = new LandArea(areaName);
            areas.add(landArea);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE,areaType);
    }

    @Override
    public String buyFood(String foodType) {
        if (!foodType.equals("Meat") && !foodType.equals("Vegetable")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }
        switch (foodType) {
            case "Meat":
                Meat meat = new Meat();
                foodRepository.add(meat);
                break;
            case "Vegetable":
                Vegetable vegetable = new Vegetable();
                foodRepository.add(vegetable);
                break;
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE,foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food =foodRepository.findByType(foodType);
        if (food==null){
            throw new IllegalArgumentException(ExceptionMessages.NO_FOOD_FOUND);
        }else {
            foodRepository.remove(food);
            Area area = areas.stream().filter(a->a.getName().equals(areaName)).findFirst().orElse(null);
            area.addFood(food);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA,foodType,areaName);
        }

    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal = null;

        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }

        Area area = areas.stream().filter(a->a.getName().equals(areaName)).findFirst().orElse(null);

        if ((animal instanceof AquaticAnimal && area instanceof LandArea) ||
                (animal instanceof TerrestrialAnimal && area instanceof WaterArea)) {
            return ConstantMessages.AREA_NOT_SUITABLE;
        }

        assert area != null;
        area.addAnimal(animal);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        int count=0;
        Area area = areas.stream().filter(a->a.getName().equals(areaName)).findFirst().orElse(null);
        for (Animal animal : area.getAnimals()) {
            animal.eat();
            count++;
        }
        return String.format(ConstantMessages.ANIMALS_FED,count);
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = areas.stream().filter(a->a.getName().equals(areaName)).findFirst().orElse(null);
        assert area != null;
        double totalKg=area.getAnimals().stream().mapToDouble(Animal::getKg).sum();

        return String.format(ConstantMessages.KILOGRAMS_AREA,areaName,totalKg);
    }

    @Override
    public String getStatistics() {

        return areas.stream().map(Area::getInfo).collect(Collectors.joining(System.lineSeparator()));

    }
}
