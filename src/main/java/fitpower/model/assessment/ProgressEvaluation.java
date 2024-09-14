package fitpower.model.assessment;

import fitpower.model.base.Date;
import java.time.LocalDateTime;
import java.util.HashMap;

public class ProgressEvaluation extends Date {

    public final HashMap<String, ProgressEvaluation> progressEvaluationMap = new HashMap<>();

    private String clientDni;
    private LocalDateTime from;
    private LocalDateTime to;
    private Float initialWeight;
    private Float finalWeight;
    private Float initialHeight;
    private Float finalHeight;

    public Float getFinalHeight() {
        return finalHeight;
    }

    public void setFinalHeight(Float finalHeight) {
        this.finalHeight = finalHeight;
    }

    public Float getInitialHeight() {
        return initialHeight;
    }

    public void setInitialHeight(Float initialHeight) {
        this.initialHeight = initialHeight;
    }

    public Float getFinalWeight() {
        return finalWeight;
    }

    public void setFinalWeight(Float finalWeight) {
        this.finalWeight = finalWeight;
    }

    public Float getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(Float initialWeight) {
        this.initialWeight = initialWeight;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public String getClientDni() {
        return clientDni;
    }

    public void setClientDni(String clientDni) {
        this.clientDni = clientDni;
    }
}
