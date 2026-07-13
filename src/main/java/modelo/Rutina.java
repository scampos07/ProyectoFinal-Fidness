package modelo;

import java.io.Serializable;
import java.util.ArrayList;
public class Rutina implements Serializable {

    private String nombreRutina;
    private NivelRutina nivelRutina;
    private ArrayList<Ejercicio> listaEjercicios;
    private Usuario propietario;
   
     // Constructor de la clase Rutina.
    public Rutina(String nombreRutina, NivelRutina nivelRutina) {
        this.nombreRutina = nombreRutina;
        this.nivelRutina = nivelRutina;
        this.propietario = propietario;
        this.listaEjercicios = new ArrayList<>();
    }
     // Agrega un ejercicio a la rutina.
    public void agregarEjercicio(Ejercicio ejercicio) {
        listaEjercicios.add(ejercicio);
    }
     // Elimina un ejercicio de la rutina.
    public void eliminarEjercicio(Ejercicio ejercicio) {
        listaEjercicios.remove(ejercicio);
    }
     // Muestra todos los ejercicios que pertenecen a la rutina.
    public void mostrarRutina() {

        System.out.println("\n==============================");
        System.out.println("Rutina: " + nombreRutina);
        System.out.println("Nivel: " + nivelRutina);
        System.out.println("==============================");
        if (listaEjercicios.isEmpty()) {
            System.out.println("La rutina no contiene ejercicios.");
        } else {
            for (Ejercicio ejercicio : listaEjercicios) {
                System.out.println("- " + ejercicio.getNombre());
            }
        }
    }
    /**
     * Simula la exportación de una rutina.
     * En la siguiente fase se implementará mediante serialización.
     */
    public void exportarRutina() {

        System.out.println("La rutina \"" + nombreRutina + "\" fue exportada correctamente.");
    }
    // Getters y Setters
    public String getNombreRutina() {
        return nombreRutina;
    }
    public void setNombreRutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
    }
    public NivelRutina getNivelRutina() {
        return nivelRutina;
    }
    public void setNivelRutina(NivelRutina nivelRutina) {
        this.nivelRutina = nivelRutina;
    }
    public Usuario getPropietario() {
        return propietario;
}
    public ArrayList<Ejercicio> getListaEjercicios() {
        return listaEjercicios;
    }
    /**
     * Devuelve el nombre de la rutina para mostrarlo
     * automáticamente en componentes Swing como JComboBox y JList.
     */
    @Override
    public String toString() {
        return nombreRutina;
    }
}
