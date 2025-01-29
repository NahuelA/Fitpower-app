/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitpower.repository;

import com.fitpower.model.PlanEntrenamiento;
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
public class PlanEntrenamientoRepository implements Serializable {

    public PlanEntrenamientoRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PlanEntrenamiento planEntrenamiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(planEntrenamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PlanEntrenamiento planEntrenamiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            planEntrenamiento = em.merge(planEntrenamiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = planEntrenamiento.getId();
                if (findPlanEntrenamiento(id) == null) {
                    throw new NonexistentEntityException("The planEntrenamiento with id " + id + " no longer exists.");
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
            PlanEntrenamiento planEntrenamiento;
            try {
                planEntrenamiento = em.getReference(PlanEntrenamiento.class, id);
                planEntrenamiento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The planEntrenamiento with id " + id + " no longer exists.", enfe);
            }
            em.remove(planEntrenamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PlanEntrenamiento> findPlanEntrenamientoEntities() {
        return findPlanEntrenamientoEntities(true, -1, -1);
    }

    public List<PlanEntrenamiento> findPlanEntrenamientoEntities(int maxResults, int firstResult) {
        return findPlanEntrenamientoEntities(false, maxResults, firstResult);
    }

    private List<PlanEntrenamiento> findPlanEntrenamientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PlanEntrenamiento.class));
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

    public PlanEntrenamiento findPlanEntrenamiento(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PlanEntrenamiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlanEntrenamientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PlanEntrenamiento> rt = cq.from(PlanEntrenamiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
