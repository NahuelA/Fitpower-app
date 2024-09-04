package fitpower.model.Nutricion;

import fitpower.model.Base.Fecha;

import java.time.LocalDateTime;

public class PlanDeNutricion extends Fecha {

    private String planDeNutricionId;
    private String dniCliente;
    private String dniNutricionista;
    private String objetivo;
    private Float caloriasDiarias;
    private Float proteinasDiarias;
    private Float carbohidratosDiarios;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String recomendacion;

    public String getPlanDeNutricionId() {
        return planDeNutricionId;
    }

    public void setPlanDeNutricionId(String planDeNutricionId) {
        this.planDeNutricionId = planDeNutricionId;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getDniNutricionista() {
        return dniNutricionista;
    }

    public void setDniNutricionista(String dniNutricionista) {
        this.dniNutricionista = dniNutricionista;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Float getCaloriasDiarias() {
        return caloriasDiarias;
    }

    public void setCaloriasDiarias(Float caloriasDiarias) {
        this.caloriasDiarias = caloriasDiarias;
    }

    public Float getProteinasDiarias() {
        return proteinasDiarias;
    }

    public void setProteinasDiarias(Float proteinasDiarias) {
        this.proteinasDiarias = proteinasDiarias;
    }

    public Float getCarbohidratosDiarios() {
        return carbohidratosDiarios;
    }

    public void setCarbohidratosDiarios(Float carbohidratosDiarios) {
        this.carbohidratosDiarios = carbohidratosDiarios;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
}
