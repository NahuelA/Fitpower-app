package fitpower.model;

import java.math.BigInteger;

public class Gym {

    private String name;
    private String address;
    private BigInteger phone;

    public Gym(){}

    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
