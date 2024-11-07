package com.fitpower.controller;

import com.fitpower.model.Cliente;
import com.fitpower.service.ClienteService;
import com.fitpower.service.impl.ClienteServiceImpl;

public class ClienteController {
    private ClienteService clienteService;


    public ClienteController() {
        this.clienteService = new ClienteServiceImpl();
    }

    public void save (Cliente cliente) {
        try {
            clienteService.save(cliente);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
