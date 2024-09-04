package fitpower.model.base;

import java.time.LocalDateTime;

public class Fecha {

    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaActualizacion;


    public LocalDateTime getFechaRegistro(){
        return this.fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime date){
        this.fechaRegistro = date;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
