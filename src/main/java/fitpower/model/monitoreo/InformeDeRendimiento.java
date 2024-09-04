package fitpower.model.monitoreo;

import fitpower.model.base.Fecha;

import java.time.LocalDateTime;

public class InformeDeRendimiento extends Fecha {

    private String informeDeRendimientoId;
    private String dniCliente;
    private LocalDateTime fecha;
    private String resultadoAlimenticio;
    private String resultadoFisico;
    private String detalle;

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getResultadoFisico() {
        return resultadoFisico;
    }

    public void setResultadoFisico(String resultadoFisico) {
        this.resultadoFisico = resultadoFisico;
    }

    public String getResultadoAlimenticio() {
        return resultadoAlimenticio;
    }

    public void setResultadoAlimenticio(String resultadoAlimenticio) {
        this.resultadoAlimenticio = resultadoAlimenticio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getInformeDeRendimientoId() {
        return informeDeRendimientoId;
    }

    public void setInformeDeRendimientoId(String informeDeRendimientoId) {
        this.informeDeRendimientoId = informeDeRendimientoId;
    }
}
