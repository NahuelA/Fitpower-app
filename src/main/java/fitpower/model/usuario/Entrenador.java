package fitpower.model.usuario;


import fitpower.model.rutina.Progreso;
import fitpower.model.rutina.Rutina;

import java.util.Map;

public class Entrenador {
    private Map<String, Rutina> rutinas;
    private Map<String, Progreso> progreso;

    public Map<String, Rutina> getRutinas() {
        return rutinas;
    }

    public void setRutinas(Map<String, Rutina> rutinas) {
        this.rutinas = rutinas;
    }

    public Map<String, Progreso> getProgreso() {
        return progreso;
    }

    public void setProgreso(Map<String, Progreso> progreso) {
        this.progreso = progreso;
    }
}
