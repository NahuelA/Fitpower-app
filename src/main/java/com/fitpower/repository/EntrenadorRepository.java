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
import com.fitpower.model.Entrenador;
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
public class EntrenadorRepository implements Serializable {

    public EntrenadorRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Entrenador entrenador) {
        if (entrenador.getClientes() == null) {
            entrenador.setClientes(new HashSet<Cliente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<Cliente> attachedClientes = new HashSet<Cliente>();
            for (Cliente clientesClienteToAttach : entrenador.getClientes()) {
                clientesClienteToAttach = em.getReference(clientesClienteToAttach.getClass(), clientesClienteToAttach.getId());
                attachedClientes.add(clientesClienteToAttach);
            }
            entrenador.setClientes(attachedClientes);
            em.persist(entrenador);
            for (Cliente clientesCliente : entrenador.getClientes()) {
                Entrenador oldEntrenadorOfClientesCliente = clientesCliente.getEntrenador();
                clientesCliente.setEntrenador(entrenador);
                clientesCliente = em.merge(clientesCliente);
                if (oldEntrenadorOfClientesCliente != null) {
                    oldEntrenadorOfClientesCliente.getClientes().remove(clientesCliente);
                    oldEntrenadorOfClientesCliente = em.merge(oldEntrenadorOfClientesCliente);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Entrenador entrenador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entrenador persistentEntrenador = em.find(Entrenador.class, entrenador.getId());
            Set<Cliente> clientesOld = persistentEntrenador.getClientes();
            Set<Cliente> clientesNew = entrenador.getClientes();
            Set<Cliente> attachedClientesNew = new HashSet<Cliente>();
            for (Cliente clientesNewClienteToAttach : clientesNew) {
                clientesNewClienteToAttach = em.getReference(clientesNewClienteToAttach.getClass(), clientesNewClienteToAttach.getId());
                attachedClientesNew.add(clientesNewClienteToAttach);
            }
            clientesNew = attachedClientesNew;
            entrenador.setClientes(clientesNew);
            entrenador = em.merge(entrenador);
            for (Cliente clientesOldCliente : clientesOld) {
                if (!clientesNew.contains(clientesOldCliente)) {
                    clientesOldCliente.setEntrenador(null);
                    clientesOldCliente = em.merge(clientesOldCliente);
                }
            }
            for (Cliente clientesNewCliente : clientesNew) {
                if (!clientesOld.contains(clientesNewCliente)) {
                    Entrenador oldEntrenadorOfClientesNewCliente = clientesNewCliente.getEntrenador();
                    clientesNewCliente.setEntrenador(entrenador);
                    clientesNewCliente = em.merge(clientesNewCliente);
                    if (oldEntrenadorOfClientesNewCliente != null && !oldEntrenadorOfClientesNewCliente.equals(entrenador)) {
                        oldEntrenadorOfClientesNewCliente.getClientes().remove(clientesNewCliente);
                        oldEntrenadorOfClientesNewCliente = em.merge(oldEntrenadorOfClientesNewCliente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = entrenador.getId();
                if (findEntrenador(id) == null) {
                    throw new NonexistentEntityException("The entrenador with id " + id + " no longer exists.");
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
            Entrenador entrenador;
            try {
                entrenador = em.getReference(Entrenador.class, id);
                entrenador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entrenador with id " + id + " no longer exists.", enfe);
            }
            Set<Cliente> clientes = entrenador.getClientes();
            for (Cliente clientesCliente : clientes) {
                clientesCliente.setEntrenador(null);
                clientesCliente = em.merge(clientesCliente);
            }
            em.remove(entrenador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Entrenador> findEntrenadorEntities() {
        return findEntrenadorEntities(true, -1, -1);
    }

    public List<Entrenador> findEntrenadorEntities(int maxResults, int firstResult) {
        return findEntrenadorEntities(false, maxResults, firstResult);
    }

    private List<Entrenador> findEntrenadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Entrenador.class));
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

    public Entrenador findEntrenador(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Entrenador.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntrenadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Entrenador> rt = cq.from(Entrenador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
