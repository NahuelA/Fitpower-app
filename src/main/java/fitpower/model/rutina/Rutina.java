package fitpower.model.Rutina;

import fitpower.model.Base.Fecha;

public class Rutina extends Fecha {

    private String rutinaId;
    private String dniCliente;
    private String dniEntrenador;
    private String nombre;
    private Integer series;
    private Integer repeticiones;
    private Integer descanso;

    public String getRutinaId() {
        return rutinaId;
    }

    public void setRutinaId(String rutinaId) {
        this.rutinaId = rutinaId;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getDniEntrenador() {
        return dniEntrenador;
    }

    public void setDniEntrenador(String dniEntrenador) {
        this.dniEntrenador = dniEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Integer getDescanso() {
        return descanso;
    }

    public void setDescanso(Integer descanso) {
        this.descanso = descanso;
    }
}
