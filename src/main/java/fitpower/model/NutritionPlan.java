package fitpower.model;

import java.time.LocalDateTime;

public class NutritionPlan {

    private String objective;
    private Float targetWeight;
    private Float initialWeight;
    private Float dailyCalories;
    private Float dailyProteins;
    private Float dailyCarbohydrates;
    private Float dailyFats;
    private boolean active;
    private LocalDateTime initialDate;
    private LocalDateTime endDate;

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDateTime initialDate) {
        this.initialDate = initialDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Float getDailyFats() {
        return dailyFats;
    }

    public void setDailyFats(Float dailyFats) {
        this.dailyFats = dailyFats;
    }

    public Float getDailyCarbohydrates() {
        return dailyCarbohydrates;
    }

    public void setDailyCarbohydrates(Float dailyCarbohydrates) {
        this.dailyCarbohydrates = dailyCarbohydrates;
    }

    public Float getDailyProteins() {
        return dailyProteins;
    }

    public void setDailyProteins(Float dailyProteins) {
        this.dailyProteins = dailyProteins;
    }

    public Float getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(Float dailyCalories) {
        this.dailyCalories = dailyCalories;
    }

    public Float getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(Float initialWeight) {
        this.initialWeight = initialWeight;
    }

    public Float getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(Float targetWeight) {
        this.targetWeight = targetWeight;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String recomendation;
}
