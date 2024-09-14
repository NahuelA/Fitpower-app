package fitpower.model.routine;

import fitpower.model.base.Date;

import java.util.HashMap;

public class Routine extends Date {

    public final HashMap<String, Routine> routineMap = new HashMap<>();

    private String routineId;
    private String clientDni;
    private String trainerDni;
    private String name;
    private Integer sets;
    private Integer repetitions;
    private Integer rest;

    public String getRoutineId() {
        return routineId;
    }

    public void setRoutineId(String routineId) {
        this.routineId = routineId;
    }

    public String getClientDni() {
        return clientDni;
    }

    public void setClientDni(String clientDni) {
        this.clientDni = clientDni;
    }

    public String getTrainerDni() {
        return trainerDni;
    }

    public void setTrainerDni(String trainerDni) {
        this.trainerDni = trainerDni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Integer getRest() {
        return rest;
    }

    public void setRest(Integer rest) {
        this.rest = rest;
    }
}
