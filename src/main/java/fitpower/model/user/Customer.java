package fitpower.model.user;

import java.util.HashMap;

public class Customer extends User {

    public HashMap<String, Customer> customerMap = new HashMap<>();

    private String customerId;

    public Customer(){}

    public Customer(
            String firstName,
            String lastName,
            String dni,
            String email,
            String phone,
            String address,
            boolean active
    ){
        super(firstName, lastName, dni, email, phone, address, active);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
