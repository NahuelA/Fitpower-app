/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitpower.controller;

import com.fitpower.model.Usuario;
import com.fitpower.repository.Conexion;
import com.fitpower.repository.UsuarioJpaController;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador de Login de Usuario
 *
 */
public class LoginController {

    //DAO
    private final UsuarioJpaController usuarioDAO;

    //Model
    private static Usuario usuarioRegistradoInstanciaUnica = null;

    public LoginController() {
        //Inicializacion de DAO
        this.usuarioDAO = new UsuarioJpaController(Conexion.getEmf());
    }

    private synchronized static void createInstanceUsuario() {
        if (usuarioRegistradoInstanciaUnica == null) {
            usuarioRegistradoInstanciaUnica = new Usuario();
        }
    }

    public static Usuario getInstanceUsuario() {
        createInstanceUsuario();
        return usuarioRegistradoInstanciaUnica;
    }

    public boolean iniciarSesion(Usuario unUsuario) {
        boolean estado = false;
        usuarioRegistradoInstanciaUnica = usuarioDAO.iniciarSesion(unUsuario);
        if (usuarioRegistradoInstanciaUnica != null) {
            try {
                createInstanceUsuario();
                estado = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return estado;
    }

}
