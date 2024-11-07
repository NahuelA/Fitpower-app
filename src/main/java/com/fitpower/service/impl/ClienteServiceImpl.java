package com.fitpower.service.impl;

import com.fitpower.model.Cliente;
import com.fitpower.repository.ClienteRepository;
import com.fitpower.repository.Conexion;
import com.fitpower.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;


    public ClienteServiceImpl() {
        this.clienteRepository = new ClienteRepository(Conexion.getEmf());
    }

    @Override
    public void save(Cliente cliente) {
       //......
        clienteRepository.create(cliente);
    }


}
