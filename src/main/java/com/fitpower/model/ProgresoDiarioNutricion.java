/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitpower.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nahuela
 */
@Entity
public class ProgresoDiarioNutricion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float caloriasDiarias;
    private Float proteinasDiarias;
    private Float carbohidratosDiarios;
    private Float grasasDiarias;
    private Float pesoActual;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCaloriasDiarias() {
        return caloriasDiarias;
    }

    public void setCaloriasDiarias(Float caloriasDiarias) {
        this.caloriasDiarias = caloriasDiarias;
    }

    public Float getProteinasDiarias() {
        return proteinasDiarias;
    }

    public void setProteinasDiarias(Float proteinasDiarias) {
        this.proteinasDiarias = proteinasDiarias;
    }

    public Float getCarbohidratosDiarios() {
        return carbohidratosDiarios;
    }

    public void setCarbohidratosDiarios(Float carbohidratosDiarios) {
        this.carbohidratosDiarios = carbohidratosDiarios;
    }

    public Float getGrasasDiarias() {
        return grasasDiarias;
    }

    public void setGrasasDiarias(Float grasasDiarias) {
        this.grasasDiarias = grasasDiarias;
    }

    public Float getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Float pesoActual) {
        this.pesoActual = pesoActual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgresoDiarioNutricion)) {
            return false;
        }
        ProgresoDiarioNutricion other = (ProgresoDiarioNutricion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fitpower.model.ProgresoDiarioNutricion[ id=" + id + " ]";
    }

}
