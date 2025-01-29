/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitpower.repository;

import com.fitpower.model.Cliente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.fitpower.model.Usuario;
import com.fitpower.model.Entrenador;
import com.fitpower.model.NotificacionEntrenamiento;
import com.fitpower.repository.exceptions.NonexistentEntityException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author NahuelA
 */
public class ClienteRepository implements Serializable {

    public ClienteRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        if (cliente.getNotificacionEntrenamientos() == null) {
            cliente.setNotificacionEntrenamientos(new HashSet<NotificacionEntrenamiento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario = cliente.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getId());
                cliente.setUsuario(usuario);
            }
            Entrenador entrenador = cliente.getEntrenador();
            if (entrenador != null) {
                entrenador = em.getReference(entrenador.getClass(), entrenador.getId());
                cliente.setEntrenador(entrenador);
            }
            Set<NotificacionEntrenamiento> attachedNotificacionEntrenamientos = new HashSet<NotificacionEntrenamiento>();
            for (NotificacionEntrenamiento notificacionEntrenamientosNotificacionEntrenamientoToAttach : cliente.getNotificacionEntrenamientos()) {
                notificacionEntrenamientosNotificacionEntrenamientoToAttach = em.getReference(notificacionEntrenamientosNotificacionEntrenamientoToAttach.getClass(), notificacionEntrenamientosNotificacionEntrenamientoToAttach.getId());
                attachedNotificacionEntrenamientos.add(notificacionEntrenamientosNotificacionEntrenamientoToAttach);
            }
            cliente.setNotificacionEntrenamientos(attachedNotificacionEntrenamientos);
            em.persist(cliente);
            if (usuario != null) {
                Cliente oldClienteOfUsuario = usuario.getCliente();
                if (oldClienteOfUsuario != null) {
                    oldClienteOfUsuario.setUsuario(null);
                    oldClienteOfUsuario = em.merge(oldClienteOfUsuario);
                }
                usuario.setCliente(cliente);
                usuario = em.merge(usuario);
            }
            if (entrenador != null) {
                entrenador.getClientes().add(cliente);
                entrenador = em.merge(entrenador);
            }
            for (NotificacionEntrenamiento notificacionEntrenamientosNotificacionEntrenamiento : cliente.getNotificacionEntrenamientos()) {
                Cliente oldClienteOfNotificacionEntrenamientosNotificacionEntrenamiento = notificacionEntrenamientosNotificacionEntrenamiento.getCliente();
                notificacionEntrenamientosNotificacionEntrenamiento.setCliente(cliente);
                notificacionEntrenamientosNotificacionEntrenamiento = em.merge(notificacionEntrenamientosNotificacionEntrenamiento);
                if (oldClienteOfNotificacionEntrenamientosNotificacionEntrenamiento != null) {
                    oldClienteOfNotificacionEntrenamientosNotificacionEntrenamiento.getNotificacionEntrenamientos().remove(notificacionEntrenamientosNotificacionEntrenamiento);
                    oldClienteOfNotificacionEntrenamientosNotificacionEntrenamiento = em.merge(oldClienteOfNotificacionEntrenamientosNotificacionEntrenamiento);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getId());
            Usuario usuarioOld = persistentCliente.getUsuario();
            Usuario usuarioNew = cliente.getUsuario();
            Entrenador entrenadorOld = persistentCliente.getEntrenador();
            Entrenador entrenadorNew = cliente.getEntrenador();
            Set<NotificacionEntrenamiento> notificacionEntrenamientosOld = persistentCliente.getNotificacionEntrenamientos();
            Set<NotificacionEntrenamiento> notificacionEntrenamientosNew = cliente.getNotificacionEntrenamientos();
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getId());
                cliente.setUsuario(usuarioNew);
            }
            if (entrenadorNew != null) {
                entrenadorNew = em.getReference(entrenadorNew.getClass(), entrenadorNew.getId());
                cliente.setEntrenador(entrenadorNew);
            }
            Set<NotificacionEntrenamiento> attachedNotificacionEntrenamientosNew = new HashSet<NotificacionEntrenamiento>();
            for (NotificacionEntrenamiento notificacionEntrenamientosNewNotificacionEntrenamientoToAttach : notificacionEntrenamientosNew) {
                notificacionEntrenamientosNewNotificacionEntrenamientoToAttach = em.getReference(notificacionEntrenamientosNewNotificacionEntrenamientoToAttach.getClass(), notificacionEntrenamientosNewNotificacionEntrenamientoToAttach.getId());
                attachedNotificacionEntrenamientosNew.add(notificacionEntrenamientosNewNotificacionEntrenamientoToAttach);
            }
            notificacionEntrenamientosNew = attachedNotificacionEntrenamientosNew;
            cliente.setNotificacionEntrenamientos(notificacionEntrenamientosNew);
            cliente = em.merge(cliente);
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.setCliente(null);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                Cliente oldClienteOfUsuario = usuarioNew.getCliente();
                if (oldClienteOfUsuario != null) {
                    oldClienteOfUsuario.setUsuario(null);
                    oldClienteOfUsuario = em.merge(oldClienteOfUsuario);
                }
                usuarioNew.setCliente(cliente);
                usuarioNew = em.merge(usuarioNew);
            }
            if (entrenadorOld != null && !entrenadorOld.equals(entrenadorNew)) {
                entrenadorOld.getClientes().remove(cliente);
                entrenadorOld = em.merge(entrenadorOld);
            }
            if (entrenadorNew != null && !entrenadorNew.equals(entrenadorOld)) {
                entrenadorNew.getClientes().add(cliente);
                entrenadorNew = em.merge(entrenadorNew);
            }
            for (NotificacionEntrenamiento notificacionEntrenamientosOldNotificacionEntrenamiento : notificacionEntrenamientosOld) {
                if (!notificacionEntrenamientosNew.contains(notificacionEntrenamientosOldNotificacionEntrenamiento)) {
                    notificacionEntrenamientosOldNotificacionEntrenamiento.setCliente(null);
                    notificacionEntrenamientosOldNotificacionEntrenamiento = em.merge(notificacionEntrenamientosOldNotificacionEntrenamiento);
                }
            }
            for (NotificacionEntrenamiento notificacionEntrenamientosNewNotificacionEntrenamiento : notificacionEntrenamientosNew) {
                if (!notificacionEntrenamientosOld.contains(notificacionEntrenamientosNewNotificacionEntrenamiento)) {
                    Cliente oldClienteOfNotificacionEntrenamientosNewNotificacionEntrenamiento = notificacionEntrenamientosNewNotificacionEntrenamiento.getCliente();
                    notificacionEntrenamientosNewNotificacionEntrenamiento.setCliente(cliente);
                    notificacionEntrenamientosNewNotificacionEntrenamiento = em.merge(notificacionEntrenamientosNewNotificacionEntrenamiento);
                    if (oldClienteOfNotificacionEntrenamientosNewNotificacionEntrenamiento != null && !oldClienteOfNotificacionEntrenamientosNewNotificacionEntrenamiento.equals(cliente)) {
                        oldClienteOfNotificacionEntrenamientosNewNotificacionEntrenamiento.getNotificacionEntrenamientos().remove(notificacionEntrenamientosNewNotificacionEntrenamiento);
                        oldClienteOfNotificacionEntrenamientosNewNotificacionEntrenamiento = em.merge(oldClienteOfNotificacionEntrenamientosNewNotificacionEntrenamiento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cliente.getId();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            Usuario usuario = cliente.getUsuario();
            if (usuario != null) {
                usuario.setCliente(null);
                usuario = em.merge(usuario);
            }
            Entrenador entrenador = cliente.getEntrenador();
            if (entrenador != null) {
                entrenador.getClientes().remove(cliente);
                entrenador = em.merge(entrenador);
            }
            Set<NotificacionEntrenamiento> notificacionEntrenamientos = cliente.getNotificacionEntrenamientos();
            for (NotificacionEntrenamiento notificacionEntrenamientosNotificacionEntrenamiento : notificacionEntrenamientos) {
                notificacionEntrenamientosNotificacionEntrenamiento.setCliente(null);
                notificacionEntrenamientosNotificacionEntrenamiento = em.merge(notificacionEntrenamientosNotificacionEntrenamiento);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
