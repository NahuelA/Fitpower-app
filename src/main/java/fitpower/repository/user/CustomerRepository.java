package fitpower.repository.user;

import fitpower.model.user.Customer;
import fitpower.repository.interfaces.user.ICustomerRepository;

import java.util.HashMap;

public class CustomerRepository implements ICustomerRepository {

    private final Customer customer = new Customer();

    @Override
    public void save(Customer customer) {
        customer.customerMap.put(customer.getDni(), customer);
    }

    @Override
    public Customer find(String dni) {
        return customer.customerMap.get(dni);
    }

    @Override
    public HashMap<String, Customer> findAll() {
        return customer.customerMap;
    }

    @Override
    public void remove(String dni) {
        customer.customerMap.remove(dni);
    }

    @Override
    public void put(String dni, Customer customer) {
        remove(dni);
        save(customer);
    }
}
