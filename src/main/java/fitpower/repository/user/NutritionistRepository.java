package fitpower.repository.user;

import fitpower.model.user.Nutritionist;
import fitpower.repository.interfaces.user.INutritionistRepository;

import java.util.Map;

public class NutritionistRepository implements INutritionistRepository {

    public Nutritionist nutritionist = new Nutritionist();

    @Override
    public void save(Nutritionist nutritionist) {

    }

    @Override
    public Nutritionist find(String dni) {
        return null;
    }

    @Override
    public Map<String, Nutritionist> findAll() {
        return Map.of();
    }

    @Override
    public void remove(String dni) {

    }

    @Override
    public void put(String nutritionistId, Nutritionist nutritionist) {

    }
}
