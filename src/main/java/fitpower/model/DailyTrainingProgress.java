package fitpower.model;

import java.time.LocalDateTime;

public class DailyTrainingProgress {

    private LocalDateTime date;

    public DailyTrainingProgress(){}

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
