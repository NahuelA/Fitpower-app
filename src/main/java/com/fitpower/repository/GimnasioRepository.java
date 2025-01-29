/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitpower.repository;

import com.fitpower.model.Gimnasio;
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
public class GimnasioRepository implements Serializable {

    public GimnasioRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gimnasio gimnasio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(gimnasio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gimnasio gimnasio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            gimnasio = em.merge(gimnasio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = gimnasio.getId();
                if (findGimnasio(id) == null) {
                    throw new NonexistentEntityException("The gimnasio with id " + id + " no longer exists.");
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
            Gimnasio gimnasio;
            try {
                gimnasio = em.getReference(Gimnasio.class, id);
                gimnasio.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gimnasio with id " + id + " no longer exists.", enfe);
            }
            em.remove(gimnasio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gimnasio> findGimnasioEntities() {
        return findGimnasioEntities(true, -1, -1);
    }

    public List<Gimnasio> findGimnasioEntities(int maxResults, int firstResult) {
        return findGimnasioEntities(false, maxResults, firstResult);
    }

    private List<Gimnasio> findGimnasioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gimnasio.class));
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

    public Gimnasio findGimnasio(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gimnasio.class, id);
        } finally {
            em.close();
        }
    }

    public int getGimnasioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gimnasio> rt = cq.from(Gimnasio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
