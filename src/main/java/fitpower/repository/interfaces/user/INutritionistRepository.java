package fitpower.repository.interfaces.user;

import fitpower.model.user.Nutritionist;
import java.util.Map;

public interface INutritionistRepository {

    public void save(Nutritionist nutritionist);
    public Nutritionist find(String dni);
    public Map<String, Nutritionist> findAll();
    public void remove(String dni);
    public void put(String nutritionistId, Nutritionist nutritionist);
}
