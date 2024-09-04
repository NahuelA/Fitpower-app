package fitpower.model.operativa;

import fitpower.model.base.Fecha;

import java.time.LocalDateTime;

public class Reunion extends Fecha {

    private String dniCliente;
    private String dniProfesional;
    private LocalDateTime fecha;
    private int duracion;
    private String tipo;
    private int cupo;

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getDniProfesional() {
        return dniProfesional;
    }

    public void setDniProfesional(String dniProfesional) {
        this.dniProfesional = dniProfesional;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
}
