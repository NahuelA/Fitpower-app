/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitpower.service.impl;

import com.fitpower.model.Rutina;
import com.fitpower.repository.RutinaRepository;
import com.fitpower.repository.exceptions.NonexistentEntityException;
import com.fitpower.service.RutinaService;
import java.util.List;

/**
 *
 * @author nahuela
 */
public class RutinaServiceImpl implements RutinaService {

    private final RutinaRepository rutinaRepository;

    public RutinaServiceImpl(RutinaRepository rutinaRepository) {
        this.rutinaRepository = rutinaRepository;
    }

    @Override
    public void create(Rutina rutina) {
        rutinaRepository.create(rutina);
    }

    @Override
    public void edit(Rutina rutina) throws NonexistentEntityException, Exception {
        rutinaRepository.edit(rutina);
    }

    @Override
    public void destroy(Long id) throws NonexistentEntityException {
        rutinaRepository.destroy(id);
    }

    @Override
    public List<Rutina> findRutinaEntities() {
        return rutinaRepository.findRutinaEntities();
    }

    @Override
    public List<Rutina> findRutinaEntities(int maxResults, int firstResult) {
        return rutinaRepository.findRutinaEntities(maxResults, firstResult);
    }

    @Override
    public Rutina findRutina(Long id) {
        return rutinaRepository.findRutina(id);
    }

    @Override
    public int getRutinaCount() {
        return rutinaRepository.getRutinaCount();
    }
}
