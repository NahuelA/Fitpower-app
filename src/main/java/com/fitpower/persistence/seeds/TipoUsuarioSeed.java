package com.fitpower.persistence.seeds;

import com.fitpower.model.TipoUsuario;
import com.fitpower.repository.TipoUsuarioRepository;

import javax.persistence.EntityManagerFactory;

public class TipoUsuarioSeed {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioSeed(EntityManagerFactory emf){
        tipoUsuarioRepository = new TipoUsuarioRepository(emf);

        crearTipoDeUsuario("admin");
        crearTipoDeUsuario("cliente");
        crearTipoDeUsuario("entrenador");
        crearTipoDeUsuario("nutricionista");
    }

    public void crearTipoDeUsuario(String tipo){
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setNombre(tipo);

        tipoUsuarioRepository.create(tipoUsuario);
    }
}
