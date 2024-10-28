package fitpower.model;

import java.time.LocalDateTime;

public class Routine {

    private String name;
    private LocalDateTime creationDate;

    public Routine(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
