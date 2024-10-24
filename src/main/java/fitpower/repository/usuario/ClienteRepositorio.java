package fitpower.repository.usuario;

import fitpower.model.usuario.Cliente;
import fitpower.repository.interfaces.usuario.IClienteRepositorio;

import java.util.HashMap;
import java.util.Map;

public class ClienteRepositorio implements IClienteRepositorio {

    public Cliente cliente = new Cliente();

    public  Map<String, Cliente> clienteMap = new HashMap<String ,Cliente >();


    @Override
    public void save(Cliente cliente) {

    }

    @Override
    public Cliente find(String dni) {
        return null;
    }

    @Override
    public Map<String, Cliente> finAll() {
        return Map.of();
    }

    @Override
    public void remove(String dni) {

    }

    @Override
    public void put(String clientId, Cliente cliente) {

    }
}
