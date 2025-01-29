/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitpower.repository;

import com.fitpower.model.ProgresoDiarioEntrenamiento;
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
public class ProgresoDiarioEntrenamientoRepository implements Serializable {

    public ProgresoDiarioEntrenamientoRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProgresoDiarioEntrenamiento progresoDiarioEntrenamiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(progresoDiarioEntrenamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProgresoDiarioEntrenamiento progresoDiarioEntrenamiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            progresoDiarioEntrenamiento = em.merge(progresoDiarioEntrenamiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = progresoDiarioEntrenamiento.getId();
                if (findProgresoDiarioEntrenamiento(id) == null) {
                    throw new NonexistentEntityException("The progresoDiarioEntrenamiento with id " + id + " no longer exists.");
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
            ProgresoDiarioEntrenamiento progresoDiarioEntrenamiento;
            try {
                progresoDiarioEntrenamiento = em.getReference(ProgresoDiarioEntrenamiento.class, id);
                progresoDiarioEntrenamiento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The progresoDiarioEntrenamiento with id " + id + " no longer exists.", enfe);
            }
            em.remove(progresoDiarioEntrenamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProgresoDiarioEntrenamiento> findProgresoDiarioEntrenamientoEntities() {
        return findProgresoDiarioEntrenamientoEntities(true, -1, -1);
    }

    public List<ProgresoDiarioEntrenamiento> findProgresoDiarioEntrenamientoEntities(int maxResults, int firstResult) {
        return findProgresoDiarioEntrenamientoEntities(false, maxResults, firstResult);
    }

    private List<ProgresoDiarioEntrenamiento> findProgresoDiarioEntrenamientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProgresoDiarioEntrenamiento.class));
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

    public ProgresoDiarioEntrenamiento findProgresoDiarioEntrenamiento(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProgresoDiarioEntrenamiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getProgresoDiarioEntrenamientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProgresoDiarioEntrenamiento> rt = cq.from(ProgresoDiarioEntrenamiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
