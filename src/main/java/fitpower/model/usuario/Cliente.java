package fitpower.model.usuario;

import java.util.HashMap;
import java.util.Map;

public class Cliente extends Usuario{

    public Map<String, Cliente> nutritionistMap = new HashMap<String, Cliente>();

    private String clienteId;

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
}
