package com.fitpower;

import com.fitpower.persistence.seeds.TipoUsuarioSeed;
import com.fitpower.persistence.seeds.UsuarioAdministradorSeed;
import com.fitpower.repository.Conexion;
import com.fitpower.view.JFrameLogin;

public class Main {
    public static void main(String[] args) {
        new Conexion();
        new TipoUsuarioSeed(Conexion.getEmf());
        new UsuarioAdministradorSeed(Conexion.getEmf());

        JFrameLogin login = new JFrameLogin();
    }
}