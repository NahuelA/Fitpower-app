package fitpower.model;

import java.time.LocalDateTime;

public class TrainingPlan {


    private String objective;
    private boolean active;
    private LocalDateTime date;

    public TrainingPlan(){}

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }
}
