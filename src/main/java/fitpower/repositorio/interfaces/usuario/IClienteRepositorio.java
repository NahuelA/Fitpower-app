package fitpower.repositorio.interfaces.usuario;

import fitpower.model.usuario.Cliente;

import java.util.Map;

public interface IClienteRepositorio {

    public void save (Cliente);

    public Cliente find(String dni);

    public Map<String, Cliente> finAll();

    public  void remove (String dni);

    public void put (String clientId, Cliente cliente);

}
