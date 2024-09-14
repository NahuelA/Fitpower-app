package fitpower.model.user;

import java.util.HashMap;

public class Admin extends User {

    public HashMap<String, Admin> adminMap = new HashMap<>();

    private String adminId;

    public Admin(){}

    public Admin(
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

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
