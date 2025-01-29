/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitpower.repository;

import com.fitpower.model.NotificacionNutricion;
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
public class NotificacionNutricionistaRepository implements Serializable {

    public NotificacionNutricionistaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NotificacionNutricion notificacionNutricion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(notificacionNutricion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NotificacionNutricion notificacionNutricion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            notificacionNutricion = em.merge(notificacionNutricion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = notificacionNutricion.getId();
                if (findNotificacionNutricion(id) == null) {
                    throw new NonexistentEntityException("The notificacionNutricion with id " + id + " no longer exists.");
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
            NotificacionNutricion notificacionNutricion;
            try {
                notificacionNutricion = em.getReference(NotificacionNutricion.class, id);
                notificacionNutricion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The notificacionNutricion with id " + id + " no longer exists.", enfe);
            }
            em.remove(notificacionNutricion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NotificacionNutricion> findNotificacionNutricionEntities() {
        return findNotificacionNutricionEntities(true, -1, -1);
    }

    public List<NotificacionNutricion> findNotificacionNutricionEntities(int maxResults, int firstResult) {
        return findNotificacionNutricionEntities(false, maxResults, firstResult);
    }

    private List<NotificacionNutricion> findNotificacionNutricionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NotificacionNutricion.class));
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

    public NotificacionNutricion findNotificacionNutricion(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NotificacionNutricion.class, id);
        } finally {
            em.close();
        }
    }

    public int getNotificacionNutricionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NotificacionNutricion> rt = cq.from(NotificacionNutricion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
