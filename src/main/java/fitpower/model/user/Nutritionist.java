package fitpower.model.user;

import java.util.HashMap;
import java.util.Map;

public class Nutritionist extends User{

    private String nutritionistId;
    private Map<String, Customer> clients;
    private Boolean isAvailable;
    private Integer limit;

    public Map<String, Nutritionist> nutritionistMap = new HashMap<>();

    public Nutritionist(){}

    public Nutritionist(
        String name,
        String surname,
        String dni,
        String email,
        String phone,
        String address,
        boolean active,
        boolean isAvailable,
        int limit,
        Map<String, Customer> clients
    )  {
        super(name,surname,dni,email,phone,address,active);
        this.isAvailable=isAvailable;
        this.limit=limit;
        this.clients=clients;
    }

    public String getNutritionistId() {
        return nutritionistId;
    }

    public void setNutritionistId(String nutritionistId) {
        this.nutritionistId = nutritionistId;
    }

    public Map<String, Customer> getClients() {
        return clients;
    }

    public void setClients(Map<String, Customer> clients) {
        this.clients = clients;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
