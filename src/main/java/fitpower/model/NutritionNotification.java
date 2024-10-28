package fitpower.model;

import java.time.LocalDateTime;

public class NutritionNotification {

    public LocalDateTime day;
    public String observation;

    public NutritionNotification(){}

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }
}
