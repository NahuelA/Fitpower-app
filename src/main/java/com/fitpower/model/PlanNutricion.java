/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitpower.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nahuela
 */
@Entity
public class PlanNutricion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String objetivo;
    private String pesoObjetivo;
    private String pesoInicial;
    private Boolean activo;
    private Float caloriasDiarias;
    private Float proteinasDiarias;
    private Float carbohidratosDiarios;
    private Float grasasDiarias;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String recomendacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getPesoObjetivo() {
        return pesoObjetivo;
    }

    public void setPesoObjetivo(String pesoObjetivo) {
        this.pesoObjetivo = pesoObjetivo;
    }

    public String getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(String pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
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
        if (!(object instanceof PlanNutricion)) {
            return false;
        }
        PlanNutricion other = (PlanNutricion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fitpower.model.PlanNutricion[ id=" + id + " ]";
    }

}
