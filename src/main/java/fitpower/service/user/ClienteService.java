package fitpower.service.user;

import fitpower.model.user.Customer;
import fitpower.service.interfaces.usuario.IClienteService;

import java.util.HashMap;
import java.util.Map;

public class ClienteService implements IClienteService {

    public Customer customer = new Customer();
    public Map<String, Customer> clienteMap = new HashMap<>();

    public void save(){

    }

    public void find(String dni){

    }
}
