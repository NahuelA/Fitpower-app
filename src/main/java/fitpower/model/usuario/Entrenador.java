package fitpower.model.usuario;

import java.util.HashMap;
import java.util.Map;

public class Entrenador {
    private String nombre;
    private String apellido;
    private String dni;
    private Map<String, Cliente> clientes;
    private int cupo;
    private boolean disponible;

    public Entrenador(String nombre, String apellido, String dni, int cupo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.clientes = new HashMap<>();
        this.cupo = cupo;
        this.disponible = cupo > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public int getCupo() {
        return cupo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void agregarCliente(Cliente cliente) {
        if (clientes.size() < cupo) {
            clientes.put(cliente.getDni(), cliente);
            this.disponible = clientes.size() < cupo;
        } else {
            System.out.println("No hay cupo disponible para más clientes.");
        }
    }

    @Override
    public String toString() {
        return "Entrenador { Nombre: " + nombre + ", Apellido: " + apellido + ", DNI: " + dni + ", Cupo: " + cupo + ", Disponible: " + disponible + " }";
    }
}
