package modelo;

import java.io.Serializable;

public class Ejercicio implements Serializable {

    private int idEjercicio;
    private String nombre;
    private GrupoMuscular grupoMuscular;
    private String descripcion;
    private String linkYoutube;
     //Constructor de la clase Ejercicio.
    public Ejercicio(int idEjercicio,
                     String nombre,
                     GrupoMuscular grupoMuscular,
                     String descripcion,
                     String linkYoutube) {

        this.idEjercicio = idEjercicio;
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
        this.descripcion = descripcion;
        this.linkYoutube = linkYoutube;
    }
    // Getters y Setters
    public int getIdEjercicio() {
        return idEjercicio;
    }
    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }
    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getLinkYoutube() {
        return linkYoutube;
    }
    public void setLinkYoutube(String linkYoutube) {
        this.linkYoutube = linkYoutube;
    }
    
     // Devuelve la información principal del ejercicio.
    public void mostrarDetalles() {
        System.out.println("--------------------------------");
        System.out.println("Ejercicio: " + nombre);
        System.out.println("Grupo muscular: " + grupoMuscular);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Video: " + linkYoutube);
        System.out.println("--------------------------------");
    }
      //Permite visualizar el enlace del video del ejercicio.
    public void abrirVideo() {
        System.out.println("Abriendo video...");
        System.out.println(linkYoutube);
    }
    /**
     * Permite mostrar el nombre del ejercicio cuando se utilice
     * dentro de listas o JComboBox de la interfaz gráfica.
     */
    @Override
    public String toString() {
        return nombre;
    }
}
