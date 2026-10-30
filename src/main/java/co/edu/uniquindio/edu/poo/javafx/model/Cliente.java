package co.edu.uniquindio.edu.poo.javafx.model;


public class Cliente {

    // Atributos
    private String cedula;
    private String nombre;
    private String apellido;

    // Constructor
    public Cliente(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getter de cedula
    public String getCedula() {
        return cedula;
    }

    // Setter de cedula
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    // Getter de nombre
    public String getNombre() {
        return nombre;
    }

    // Setter de nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter de apellido
    public String getApellido() {
        return apellido;
    }

    // Setter de apellido
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
