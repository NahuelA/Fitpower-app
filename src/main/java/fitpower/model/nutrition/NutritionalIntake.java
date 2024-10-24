package fitpower.model.nutrition;

import fitpower.model.base.Date;

public class NutritionalIntake extends Date {

    private String nutritionalIntakeId;
    private String clientDni;
    private Float proteinsConsumed;
    private Float carbohydratesConsumed;
    private Float caloriesConsumed;

    public Float getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(Float caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }

    public Float getCarbohydratesConsumed() {
        return carbohydratesConsumed;
    }

    public void setCarbohydratesConsumed(Float carbohydratesConsumed) {
        this.carbohydratesConsumed = carbohydratesConsumed;
    }

    public Float getProteinsConsumed() {
        return proteinsConsumed;
    }

    public void setProteinsConsumed(Float proteinsConsumed) {
        this.proteinsConsumed = proteinsConsumed;
    }

    public String getClientDni() {
        return clientDni;
    }

    public void setClientDni(String clientDni) {
        this.clientDni = clientDni;
    }

    public String getNutritionalIntakeId() {
        return nutritionalIntakeId;
    }

    public void setNutritionalIntakeId(String nutritionalIntakeId) {
        this.nutritionalIntakeId = nutritionalIntakeId;
    }
}
