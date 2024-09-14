package fitpower.model.monitoring;

import fitpower.model.base.Date;
import fitpower.model.communication.History;

import java.time.LocalDateTime;
import java.util.HashMap;

public class PerformanceReport extends Date {

    public final HashMap<String, PerformanceReport> performanceReportMap = new HashMap<>();

    private String performanceReportId;
    private String clientDni;
    private LocalDateTime date;
    private String nutritionalResult;
    private String physicalResult;
    private String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPhysicalResult() {
        return physicalResult;
    }

    public void setPhysicalResult(String physicalResult) {
        this.physicalResult = physicalResult;
    }

    public String getNutritionalResult() {
        return nutritionalResult;
    }

    public void setNutritionalResult(String nutritionalResult) {
        this.nutritionalResult = nutritionalResult;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getClientDni() {
        return clientDni;
    }

    public void setClientDni(String clientDni) {
        this.clientDni = clientDni;
    }

    public String getPerformanceReportId() {
        return performanceReportId;
    }

    public void setPerformanceReportId(String performanceReportId) {
        this.performanceReportId = performanceReportId;
    }
}
