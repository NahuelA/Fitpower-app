package fitpower.model.rutina;

import fitpower.model.base.Fecha;

import java.time.LocalDateTime;

public class Progreso extends Fecha {

    private String progresoId;
    private String dniCliente;
    private LocalDateTime fecha;
    private Float pesoActual;
    private Float estaturaActual;
    private String observacion;

    public String getProgresoId() {
        return progresoId;
    }

    public void setProgresoId(String progresoId) {
        this.progresoId = progresoId;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Float getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Float pesoActual) {
        this.pesoActual = pesoActual;
    }

    public Float getEstaturaActual() {
        return estaturaActual;
    }

    public void setEstaturaActual(Float estaturaActual) {
        this.estaturaActual = estaturaActual;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
