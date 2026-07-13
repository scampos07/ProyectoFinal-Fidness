package modelo;

import java.io.Serializable;
public abstract class Usuario implements Serializable {

    protected String nombre;
    protected String username;
    protected String password;

    public Usuario(String nombre, String username, String password) {

        this.nombre = nombre;
        this.username = username;
        this.password = password;

    }
    public String getNombre() {
        return nombre;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    // Método que implementarán las clases hijas
    public abstract void mostrarMenu();
}
