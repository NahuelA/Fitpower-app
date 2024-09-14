package fitpower.model.operational;

import fitpower.model.base.Date;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Meeting extends Date {

    private String clientDni;
    private String professionalDni;
    private LocalDateTime date;
    private int duration;
    private String type;
    private int capacity;

    public String getClientDni() {
        return clientDni;
    }

    public void setClientDni(String clientDni) {
        this.clientDni = clientDni;
    }

    public String getProfessionalDni() {
        return professionalDni;
    }

    public void setProfessionalDni(String professionalDni) {
        this.professionalDni = professionalDni;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
