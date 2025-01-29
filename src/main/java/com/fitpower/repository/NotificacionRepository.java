/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitpower.repository;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.fitpower.model.Cliente;
import com.fitpower.model.NotificacionEntrenamiento;
import com.fitpower.repository.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author NahuelA
 */
public class NotificacionRepository implements Serializable {

    public NotificacionRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NotificacionEntrenamiento notificacionEntrenamiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente = notificacionEntrenamiento.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getId());
                notificacionEntrenamiento.setCliente(cliente);
            }
            em.persist(notificacionEntrenamiento);
            if (cliente != null) {
                cliente.getNotificacionEntrenamientos().add(notificacionEntrenamiento);
                cliente = em.merge(cliente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NotificacionEntrenamiento notificacionEntrenamiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            NotificacionEntrenamiento persistentNotificacionEntrenamiento = em.find(NotificacionEntrenamiento.class, notificacionEntrenamiento.getId());
            Cliente clienteOld = persistentNotificacionEntrenamiento.getCliente();
            Cliente clienteNew = notificacionEntrenamiento.getCliente();
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getId());
                notificacionEntrenamiento.setCliente(clienteNew);
            }
            notificacionEntrenamiento = em.merge(notificacionEntrenamiento);
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getNotificacionEntrenamientos().remove(notificacionEntrenamiento);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getNotificacionEntrenamientos().add(notificacionEntrenamiento);
                clienteNew = em.merge(clienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = notificacionEntrenamiento.getId();
                if (findNotificacionEntrenamiento(id) == null) {
                    throw new NonexistentEntityException("The notificacionEntrenamiento with id " + id + " no longer exists.");
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
            NotificacionEntrenamiento notificacionEntrenamiento;
            try {
                notificacionEntrenamiento = em.getReference(NotificacionEntrenamiento.class, id);
                notificacionEntrenamiento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The notificacionEntrenamiento with id " + id + " no longer exists.", enfe);
            }
            Cliente cliente = notificacionEntrenamiento.getCliente();
            if (cliente != null) {
                cliente.getNotificacionEntrenamientos().remove(notificacionEntrenamiento);
                cliente = em.merge(cliente);
            }
            em.remove(notificacionEntrenamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NotificacionEntrenamiento> findNotificacionEntrenamientoEntities() {
        return findNotificacionEntrenamientoEntities(true, -1, -1);
    }

    public List<NotificacionEntrenamiento> findNotificacionEntrenamientoEntities(int maxResults, int firstResult) {
        return findNotificacionEntrenamientoEntities(false, maxResults, firstResult);
    }

    private List<NotificacionEntrenamiento> findNotificacionEntrenamientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NotificacionEntrenamiento.class));
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

    public NotificacionEntrenamiento findNotificacionEntrenamiento(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NotificacionEntrenamiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getNotificacionEntrenamientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NotificacionEntrenamiento> rt = cq.from(NotificacionEntrenamiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
