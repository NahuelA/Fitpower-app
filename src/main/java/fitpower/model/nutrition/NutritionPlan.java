package fitpower.model.nutrition;

import fitpower.model.base.Date;

import java.time.LocalDateTime;
import java.util.HashMap;

public class NutritionPlan extends Date {

    public final HashMap<String, NutritionPlan> nutritionPlanMap = new HashMap<>();

    private String nutritionPlanId;
    private String clientDni;
    private String nutritionistDni;
    private String goal;
    private Float dailyCalories;
    private Float dailyProteins;
    private Float dailyCarbohydrates;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String recommendation;

    public String getNutritionPlanId() {
        return nutritionPlanId;
    }

    public void setNutritionPlanId(String nutritionPlanId) {
        this.nutritionPlanId = nutritionPlanId;
    }

    public String getClientDni() {
        return clientDni;
    }

    public void setClientDni(String clientDni) {
        this.clientDni = clientDni;
    }

    public String getNutritionistDni() {
        return nutritionistDni;
    }

    public void setNutritionistDni(String nutritionistDni) {
        this.nutritionistDni = nutritionistDni;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Float getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(Float dailyCalories) {
        this.dailyCalories = dailyCalories;
    }

    public Float getDailyProteins() {
        return dailyProteins;
    }

    public void setDailyProteins(Float dailyProteins) {
        this.dailyProteins = dailyProteins;
    }

    public Float getDailyCarbohydrates() {
        return dailyCarbohydrates;
    }

    public void setDailyCarbohydrates(Float dailyCarbohydrates) {
        this.dailyCarbohydrates = dailyCarbohydrates;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
