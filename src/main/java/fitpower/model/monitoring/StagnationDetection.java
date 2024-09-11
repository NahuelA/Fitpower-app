package fitpower.model.monitoring;

import fitpower.model.base.Date;

public class StagnationDetection extends Date {

    private String clientDni;
    private Float muscleMassGainedPercentage;
    private Float heightPercentage;
    private Float caloriesConsumedPercentage;
    private String carbohydratesConsumedPercentage;
    private Float proteinsConsumedPercentage;
    private Float overallResult;
    private String details;

    public String getClientDni() {
        return clientDni;
    }

    public void setClientDni(String clientDni) {
        this.clientDni = clientDni;
    }

    public Float getMuscleMassGainedPercentage() {
        return muscleMassGainedPercentage;
    }

    public void setMuscleMassGainedPercentage(Float muscleMassGainedPercentage) {
        this.muscleMassGainedPercentage = muscleMassGainedPercentage;
    }

    public Float getHeightPercentage() {
        return heightPercentage;
    }

    public void setHeightPercentage(Float heightPercentage) {
        this.heightPercentage = heightPercentage;
    }

    public Float getCaloriesConsumedPercentage() {
        return caloriesConsumedPercentage;
    }

    public void setCaloriesConsumedPercentage(Float caloriesConsumedPercentage) {
        this.caloriesConsumedPercentage = caloriesConsumedPercentage;
    }

    public String getCarbohydratesConsumedPercentage() {
        return carbohydratesConsumedPercentage;
    }

    public void setCarbohydratesConsumedPercentage(String carbohydratesConsumedPercentage) {
        this.carbohydratesConsumedPercentage = carbohydratesConsumedPercentage;
    }

    public Float getProteinsConsumedPercentage() {
        return proteinsConsumedPercentage;
    }

    public void setProteinsConsumedPercentage(Float proteinsConsumedPercentage) {
        this.proteinsConsumedPercentage = proteinsConsumedPercentage;
    }

    public Float getOverallResult() {
        return overallResult;
    }

    public void setOverallResult(Float overallResult) {
        this.overallResult = overallResult;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
