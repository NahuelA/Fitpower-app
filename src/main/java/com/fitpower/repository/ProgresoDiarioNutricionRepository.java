/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitpower.repository;

import com.fitpower.model.ProgresoDiarioNutricion;
import com.fitpower.repository.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author NahuelA
 */
public class ProgresoDiarioNutricionRepository implements Serializable {

    public ProgresoDiarioNutricionRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProgresoDiarioNutricion progresoDiarioNutricion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(progresoDiarioNutricion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProgresoDiarioNutricion progresoDiarioNutricion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            progresoDiarioNutricion = em.merge(progresoDiarioNutricion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = progresoDiarioNutricion.getId();
                if (findProgresoDiarioNutricion(id) == null) {
                    throw new NonexistentEntityException("The progresoDiarioNutricion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProgresoDiarioNutricion progresoDiarioNutricion;
            try {
                progresoDiarioNutricion = em.getReference(ProgresoDiarioNutricion.class, id);
                progresoDiarioNutricion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The progresoDiarioNutricion with id " + id + " no longer exists.", enfe);
            }
            em.remove(progresoDiarioNutricion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProgresoDiarioNutricion> findProgresoDiarioNutricionEntities() {
        return findProgresoDiarioNutricionEntities(true, -1, -1);
    }

    public List<ProgresoDiarioNutricion> findProgresoDiarioNutricionEntities(int maxResults, int firstResult) {
        return findProgresoDiarioNutricionEntities(false, maxResults, firstResult);
    }

    private List<ProgresoDiarioNutricion> findProgresoDiarioNutricionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProgresoDiarioNutricion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ProgresoDiarioNutricion findProgresoDiarioNutricion(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProgresoDiarioNutricion.class, id);
        } finally {
            em.close();
        }
    }

    public int getProgresoDiarioNutricionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProgresoDiarioNutricion> rt = cq.from(ProgresoDiarioNutricion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
