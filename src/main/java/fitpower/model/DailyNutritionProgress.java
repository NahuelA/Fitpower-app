package fitpower.model;

public class DailyNutritionProgress {

    private Float dailyCalories;
    private Float dailyProteins;
    private Float dailyCarbohydrates;
    private Float dailyFats;
    private Float currentWeight;

    public DailyNutritionProgress(){}

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

    public Float getDailyFats() {
        return dailyFats;
    }

    public void setDailyFats(Float dailyFats) {
        this.dailyFats = dailyFats;
    }

    public Float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Float currentWeight) {
        this.currentWeight = currentWeight;
    }
}
