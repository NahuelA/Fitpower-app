package fitpower.repository.interfaces.user;

import fitpower.model.user.Customer;
import fitpower.model.user.Nutritionist;

import java.util.HashMap;

public interface ICustomerRepository {

    public void save(Customer customer);
    public Customer find(String dni);
    public HashMap<String, Customer> findAll();
    public void remove(String dni);
    public void put(String customerId, Customer customer);
}
