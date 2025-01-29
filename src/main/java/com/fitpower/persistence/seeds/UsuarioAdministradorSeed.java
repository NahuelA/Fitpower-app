/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitpower.persistence.seeds;

import com.fitpower.model.TipoUsuario;
import com.fitpower.repository.TipoUsuarioRepository;
import com.fitpower.repository.UsuarioRepository;
import javax.persistence.EntityManagerFactory;
import com.fitpower.model.Usuario;

/**
 *
 * @author nahuela
 */
public class UsuarioAdministradorSeed {

    public UsuarioAdministradorSeed(EntityManagerFactory emf) {
        UsuarioRepository usuarioRepository = new UsuarioRepository(emf);
        TipoUsuarioRepository tipoUsuarioRepository = new TipoUsuarioRepository(emf);

        Usuario usuario = new Usuario();
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findTipoUsuarioByName("admin");

        usuario.setNombre("admin");
        usuario.setEmail("admin@admin.ad");
        usuario.setClave("admin");
        usuario.setTipoUsuario(tipoUsuario);

        usuarioRepository.create(usuario);
    }
}
