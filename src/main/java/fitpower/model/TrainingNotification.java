package fitpower.model;

import java.time.LocalDateTime;

public class TrainingNotification {

    private LocalDateTime day;
    private String observation;

    public TrainingNotification(){}

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
