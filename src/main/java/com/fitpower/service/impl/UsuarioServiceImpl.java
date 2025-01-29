package com.fitpower.service.impl;

import com.fitpower.dto.UsuarioDto;
import com.fitpower.model.TipoUsuario;
import com.fitpower.model.Usuario;
import com.fitpower.repository.TipoUsuarioRepository;
import com.fitpower.repository.UsuarioRepository;
import com.fitpower.repository.exceptions.NonexistentEntityException;
import com.fitpower.service.UsuarioService;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public UsuarioServiceImpl(EntityManagerFactory emf) {
        usuarioRepository = new UsuarioRepository(emf);
        tipoUsuarioRepository = new TipoUsuarioRepository(emf);
    }

    @Override
    public void create(UsuarioDto usuarioDto) {
        if (usuarioDto.getTipoUsuario() == null)
            return;

        TipoUsuario tipoUsuario = tipoUsuarioRepository.findTipoUsuarioByName(usuarioDto.getTipoUsuario());

        if (tipoUsuario == null)
            return;

        if (
                usuarioDto.getDni() == null &&
                        usuarioDto.getNombre() == null &&
                        usuarioDto.getApellido() == null &&
                        usuarioDto.getEmail() == null &&
                        usuarioDto.getClave() == null
        )
            return;

        Usuario usuario = new Usuario(usuarioDto.getDni(), usuarioDto.getNombre(), usuarioDto.getApellido(), usuarioDto.getEmail(), usuarioDto.getClave(), tipoUsuario);

        usuarioRepository.create(usuario);
    }

    @Override
    public void edit(UsuarioDto usuarioDto) {

    }

    @Override
    public void destroy(Long id) throws NonexistentEntityException {

    }

    @Override
    public List<Usuario> findUsuarioEntities() {
        return List.of();
    }

    @Override
    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return List.of();
    }

    @Override
    public Usuario findUsuario(Long id) {
        return null;
    }

    @Override
    public int getUsuarioCount() {
        return 0;
    }
}
