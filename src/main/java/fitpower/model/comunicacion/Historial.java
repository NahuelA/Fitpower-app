package fitpower.model.comunicacion;

import fitpower.model.base.Fecha;
import fitpower.model.evaluacion.EvaluacionDeProgreso;
import fitpower.model.nutricion.PlanDeNutricion;
import fitpower.model.rutina.Rutina;

import java.util.Map;

public class Historial extends Fecha {

    private String idHistorial;
    private Map<String, Rutina> Rutinas;
    private Map<String, PlanDeNutricion> PlanesDeNutricion;
    private Map<String, EvaluacionDeProgreso> evaluacionesDeProgreso;

    public String getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(String idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Map<String, Rutina> getRutinas() {
        return Rutinas;
    }

    public void setRutinas(Map<String, Rutina> rutinas) {
        Rutinas = rutinas;
    }

    public Map<String, PlanDeNutricion> getPlanesDeNutricion() {
        return PlanesDeNutricion;
    }

    public void setPlanesDeNutricion(Map<String, PlanDeNutricion> planesDeNutricion) {
        PlanesDeNutricion = planesDeNutricion;
    }

    public Map<String, EvaluacionDeProgreso> getEvaluacionesDeProgreso() {
        return evaluacionesDeProgreso;
    }

    public void setEvaluacionesDeProgreso(Map<String, EvaluacionDeProgreso> evaluacionesDeProgreso) {
        this.evaluacionesDeProgreso = evaluacionesDeProgreso;
    }
}
