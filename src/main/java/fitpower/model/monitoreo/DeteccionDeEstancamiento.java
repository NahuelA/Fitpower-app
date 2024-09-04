package fitpower.model.monitoreo;

import fitpower.model.base.Fecha;

public class DeteccionDeEstancamiento extends Fecha {

    private String dniCliente;
    private Float porcentajeMasaMuscularGanada;
    private Float porcentajeEstatura;
    private Float porcentajeCaloriasConsumidas;
    private String porcentajeCarbohidratosConsumidos;
    private Float porcentajeProteinasConsumidas;
    private Float resultadoGeneral;
    private String detalle;

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public Float getPorcentajeMasaMuscularGanada() {
        return porcentajeMasaMuscularGanada;
    }

    public void setPorcentajeMasaMuscularGanada(Float porcentajeMasaMuscularGanada) {
        this.porcentajeMasaMuscularGanada = porcentajeMasaMuscularGanada;
    }

    public Float getPorcentajeEstatura() {
        return porcentajeEstatura;
    }

    public void setPorcentajeEstatura(Float porcentajeEstatura) {
        this.porcentajeEstatura = porcentajeEstatura;
    }

    public Float getPorcentajeCaloriasConsumidas() {
        return porcentajeCaloriasConsumidas;
    }

    public void setPorcentajeCaloriasConsumidas(Float porcentajeCaloriasConsumidas) {
        this.porcentajeCaloriasConsumidas = porcentajeCaloriasConsumidas;
    }

    public String getPorcentajeCarbohidratosConsumidos() {
        return porcentajeCarbohidratosConsumidos;
    }

    public void setPorcentajeCarbohidratosConsumidos(String porcentajeCarbohidratosConsumidos) {
        this.porcentajeCarbohidratosConsumidos = porcentajeCarbohidratosConsumidos;
    }

    public Float getPorcentajeProteinasConsumidas() {
        return porcentajeProteinasConsumidas;
    }

    public void setPorcentajeProteinasConsumidas(Float porcentajeProteinasConsumidas) {
        this.porcentajeProteinasConsumidas = porcentajeProteinasConsumidas;
    }

    public Float getResultadoGeneral() {
        return resultadoGeneral;
    }

    public void setResultadoGeneral(Float resultadoGeneral) {
        this.resultadoGeneral = resultadoGeneral;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
