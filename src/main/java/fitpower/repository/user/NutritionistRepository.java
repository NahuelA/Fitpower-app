package fitpower.repository.user;

import fitpower.model.user.Nutritionist;
import fitpower.repository.interfaces.user.INutritionistRepository;

import java.util.Map;

public class NutritionistRepository implements INutritionistRepository {

    public Nutritionist nutritionist = new Nutritionist();

    @Override
    public void save(Nutritionist nutritionist)
    {
        nutritionist.nutritionistMap.put(nutritionist.getDni(), nutritionist);
    }

    @Override
    public Nutritionist find(String dni)
    {
        return nutritionist.nutritionistMap.get(dni);
    }

    @Override
    public Map<String, Nutritionist> findAll() {
        return nutritionist.nutritionistMap;
    }

    @Override
    public void remove(String dni) {
        nutritionist.nutritionistMap.remove(dni);
    }

    @Override
    public void put(String dni, Nutritionist nutritionist) {
        remove(dni);
        save(nutritionist);
    }
}
