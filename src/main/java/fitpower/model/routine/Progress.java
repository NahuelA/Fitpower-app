package fitpower.model.routine;

import fitpower.model.base.Date;

import java.time.LocalDateTime;

public class Progress extends Date {

    private String progressId;
    private String clientDni;
    private LocalDateTime date;
    private Float currentWeight;
    private Float currentHeight;
    private String observation;

    public String getProgressId() {
        return progressId;
    }

    public void setProgressId(String progressId) {
        this.progressId = progressId;
    }

    public String getClientDni() {
        return clientDni;
    }

    public void setClientDni(String clientDni) {
        this.clientDni = clientDni;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Float currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Float getCurrentHeight() {
        return currentHeight;
    }

    public void setCurrentHeight(Float currentHeight) {
        this.currentHeight = currentHeight;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
