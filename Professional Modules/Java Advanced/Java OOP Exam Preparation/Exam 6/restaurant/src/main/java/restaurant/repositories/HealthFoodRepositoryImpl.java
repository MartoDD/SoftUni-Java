package restaurant.repositories;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

public class HealthFoodRepositoryImpl extends BaseRepository<HealthyFood> implements HealthFoodRepository<HealthyFood> {


    @Override
    public HealthyFood foodByName(String name) {
        return getAllEntities().stream().filter(food -> food.getName().equals(name)).findFirst().orElse(null);
    }
}
