package fitpower.model.evaluacion;

import fitpower.model.base.Fecha;

import java.time.LocalDateTime;

public class EvaluacionDeProgreso extends Fecha {

    private String dniCliente;
    private LocalDateTime desde;
    private LocalDateTime hasta;
    private Float pesoInicial;
    private Float pesoFinal;
    private Float estaturaInicial;
    private Float estaturaFinal;

    public Float getEstaturaFinal() {
        return estaturaFinal;
    }

    public void setEstaturaFinal(Float estaturaFinal) {
        this.estaturaFinal = estaturaFinal;
    }

    public Float getEstaturaInicial() {
        return estaturaInicial;
    }

    public void setEstaturaInicial(Float estaturaInicial) {
        this.estaturaInicial = estaturaInicial;
    }

    public Float getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(Float pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public Float getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(Float pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public LocalDateTime getHasta() {
        return hasta;
    }

    public void setHasta(LocalDateTime hasta) {
        this.hasta = hasta;
    }

    public LocalDateTime getDesde() {
        return desde;
    }

    public void setDesde(LocalDateTime desde) {
        this.desde = desde;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }
}
