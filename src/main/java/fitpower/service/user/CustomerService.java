package fitpower.service.user;

import fitpower.model.user.Customer;
import fitpower.service.interfaces.user.ICustomerService;

import java.util.HashMap;
import java.util.Map;

public class CustomerService implements ICustomerService {

    public Customer customer = new Customer();
    public Map<String, Customer> clienteMap = new HashMap<>();

    public void save(){

    }

    public void find(String dni){

    }
}
