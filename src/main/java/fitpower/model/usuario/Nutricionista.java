package fitpower.model.usuario;
import fitpower.model.nutricion.ConsumoNutricional;
import fitpower.model.nutricion.PlanDeNutricion;


import java.util.Map;


public class Nutricionista {
    private Map<String, ConsumoNutricional> consumoNutricional;
    private Map<String, PlanDeNutricion> planDeNutricion;

    public Map<String, ConsumoNutricional> getConsumoNutricional() {
        return consumoNutricional;
    }

    public void setConsumoNutricional(Map<String, ConsumoNutricional> consumoNutricional) {
        this.consumoNutricional = consumoNutricional;
    }

    public Map<String, PlanDeNutricion> getPlanDeNutricion() {
        return planDeNutricion;
    }

    public void setPlanDeNutricion(Map<String, PlanDeNutricion> planDeNutricion) {
        this.planDeNutricion = planDeNutricion;
    }
}