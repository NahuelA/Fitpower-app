package com.fitpower.service;

import com.fitpower.dto.UsuarioDto;
import com.fitpower.model.Usuario;
import com.fitpower.repository.exceptions.NonexistentEntityException;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public interface UsuarioService {

    public void create(UsuarioDto usuarioDto);
    public void edit(UsuarioDto usuarioDto);
    public void destroy(Long id) throws NonexistentEntityException;
    public List<Usuario> findUsuarioEntities();
    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult);
    public Usuario findUsuario(Long id);
    public int getUsuarioCount();
}
