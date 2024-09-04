package fitpower.model.Operativa;

import fitpower.model.Base.Fecha;

import java.time.LocalDateTime;

public class FichaAsistencia extends Fecha {

    private String fichaAsistenciaId;
    private String dniCliente;
    private int asistencias;
    private String idReunion;
    private String tipoReunion;
    private String detalle;
    private LocalDateTime fecha;

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipoReunion() {
        return tipoReunion;
    }

    public void setTipoReunion(String tipoReunion) {
        this.tipoReunion = tipoReunion;
    }

    public String getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(String idReunion) {
        this.idReunion = idReunion;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getFichaAsistenciaId() {
        return fichaAsistenciaId;
    }

    public void setFichaAsistenciaId(String fichaAsistenciaId) {
        this.fichaAsistenciaId = fichaAsistenciaId;
    }
}
