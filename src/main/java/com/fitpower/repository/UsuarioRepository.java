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
import com.fitpower.model.TipoUsuario;
import com.fitpower.model.Usuario;
import com.fitpower.repository.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author NahuelA
 */
public class UsuarioRepository implements Serializable {

    public UsuarioRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente = usuario.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getId());
                usuario.setCliente(cliente);
            }
            TipoUsuario tipoUsuario = usuario.getTipoUsuario();
            if (tipoUsuario != null) {
                tipoUsuario = em.getReference(tipoUsuario.getClass(), tipoUsuario.getId());
                usuario.setTipoUsuario(tipoUsuario);
            }
            em.persist(usuario);
            if (cliente != null) {
                Usuario oldUsuarioOfCliente = cliente.getUsuario();
                if (oldUsuarioOfCliente != null) {
                    oldUsuarioOfCliente.setCliente(null);
                    oldUsuarioOfCliente = em.merge(oldUsuarioOfCliente);
                }
                cliente.setUsuario(usuario);
                cliente = em.merge(cliente);
            }
            if (tipoUsuario != null) {
                tipoUsuario.getUsuarios().add(usuario);
                tipoUsuario = em.merge(tipoUsuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            Cliente clienteOld = persistentUsuario.getCliente();
            Cliente clienteNew = usuario.getCliente();
            TipoUsuario tipoUsuarioOld = persistentUsuario.getTipoUsuario();
            TipoUsuario tipoUsuarioNew = usuario.getTipoUsuario();
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getId());
                usuario.setCliente(clienteNew);
            }
            if (tipoUsuarioNew != null) {
                tipoUsuarioNew = em.getReference(tipoUsuarioNew.getClass(), tipoUsuarioNew.getId());
                usuario.setTipoUsuario(tipoUsuarioNew);
            }
            usuario = em.merge(usuario);
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.setUsuario(null);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                Usuario oldUsuarioOfCliente = clienteNew.getUsuario();
                if (oldUsuarioOfCliente != null) {
                    oldUsuarioOfCliente.setCliente(null);
                    oldUsuarioOfCliente = em.merge(oldUsuarioOfCliente);
                }
                clienteNew.setUsuario(usuario);
                clienteNew = em.merge(clienteNew);
            }
            if (tipoUsuarioOld != null && !tipoUsuarioOld.equals(tipoUsuarioNew)) {
                tipoUsuarioOld.getUsuarios().remove(usuario);
                tipoUsuarioOld = em.merge(tipoUsuarioOld);
            }
            if (tipoUsuarioNew != null && !tipoUsuarioNew.equals(tipoUsuarioOld)) {
                tipoUsuarioNew.getUsuarios().add(usuario);
                tipoUsuarioNew = em.merge(tipoUsuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            Cliente cliente = usuario.getCliente();
            if (cliente != null) {
                cliente.setUsuario(null);
                cliente = em.merge(cliente);
            }
            TipoUsuario tipoUsuario = usuario.getTipoUsuario();
            if (tipoUsuario != null) {
                tipoUsuario.getUsuarios().remove(usuario);
                tipoUsuario = em.merge(tipoUsuario);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
