package fitpower.repository.interfaces.usuario;

import fitpower.model.usuario.Cliente;

import java.util.Map;

public interface IClienteRepositorio {

     void save(Cliente cliente);

    Cliente find(String dni);

    Map<String, Cliente> finAll();

    void remove(String dni);

    void put(String clientId, Cliente cliente);

}
