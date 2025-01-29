/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitpower.service;

import com.fitpower.model.Rutina;
import com.fitpower.repository.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author nahuela
 */
public interface RutinaService {
    public void create(Rutina rutina);
    public void edit(Rutina rutina) throws NonexistentEntityException, Exception;
    public void destroy(Long id) throws NonexistentEntityException;
    public List<Rutina> findRutinaEntities();
    public List<Rutina> findRutinaEntities(int maxResults, int firstResult);
    public Rutina findRutina(Long id);
    public int getRutinaCount();
}
