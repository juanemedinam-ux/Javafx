package co.edu.uniquindio.edu.poo.javafx.model;


import java.util.Collection;
import java.util.LinkedList;

public class Empresa {

    // Atributos
    private String nombre;
    private Collection<Cliente> clientes;

    // Constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
        clientes = new LinkedList<>();
    }

    // Getter del nombre
    public String getNombre() {
        return nombre;
    }

    // Setter del nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter de clientes
    public Collection<Cliente> getClientes() {
        return clientes;
    }

    // Setter de clientes
    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    // Agregar cliente
    public boolean agregarCliente(Cliente cliente) {

        boolean centinela = false;

        if (!verificarCliente(cliente.getCedula())) {
            clientes.add(cliente);
            centinela = true;
        }

        return centinela;
    }

    // Eliminar cliente
    public boolean eliminarCliente(String cedula) {

        boolean centinela = false;

        for (Cliente cliente : clientes) {

            if (cliente.getCedula().equals(cedula)) {
                clientes.remove(cliente);
                centinela = true;
                break;
            }
        }

        return centinela;
    }

    // Actualizar cliente
    public boolean actualizarCliente(String cedula, Cliente actualizado) {

        boolean centinela = false;

        for (Cliente cliente : clientes) {

            if (cliente.getCedula().equals(cedula)) {

                cliente.setCedula(actualizado.getCedula());
                cliente.setNombre(actualizado.getNombre());
                cliente.setApellido(actualizado.getApellido());

                centinela = true;
                break;
            }
        }

        return centinela;
    }

    // Verificar cliente
    public boolean verificarCliente(String cedula) {

        boolean centinela = false;

        for (Cliente cliente : clientes) {

            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
                break;
            }
        }

        return centinela;
    }
}

