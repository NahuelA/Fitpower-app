package fitpower.model.nutricion;

import fitpower.model.base.Fecha;

public class ConsumoNutricional extends Fecha {

    private String consumoNutricionalId;
    private String dniCliente;
    private Float proteinasConsumidas;
    private Float carbohidratosConsumidos;
    private Float caloriasConsumidas;

    public Float getCaloriasConsumidas() {
        return caloriasConsumidas;
    }

    public void setCaloriasConsumidas(Float caloriasConsumidas) {
        this.caloriasConsumidas = caloriasConsumidas;
    }

    public Float getCarbohidratosConsumidos() {
        return carbohidratosConsumidos;
    }

    public void setCarbohidratosConsumidos(Float carbohidratosConsumidos) {
        this.carbohidratosConsumidos = carbohidratosConsumidos;
    }

    public Float getProteinasConsumidas() {
        return proteinasConsumidas;
    }

    public void setProteinasConsumidas(Float proteinasConsumidas) {
        this.proteinasConsumidas = proteinasConsumidas;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getConsumoNutricionalId() {
        return consumoNutricionalId;
    }

    public void setConsumoNutricionalId(String consumoNutricionalId) {
        this.consumoNutricionalId = consumoNutricionalId;
    }
}
