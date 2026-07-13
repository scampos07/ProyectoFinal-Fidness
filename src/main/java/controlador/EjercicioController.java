package controlador;

import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import modelo.Ejercicio;
import persistencia.DatosIniciales;

public class EjercicioController {

    //Lista de ejercicios disponibles.
    private ArrayList<Ejercicio> ejercicios;

    /**
     * Constructor.
     * Al iniciar el controlador se cargan los ejercicios
     * predeterminados del sistema.
     */
    public EjercicioController() {
        ejercicios = DatosIniciales.cargarEjercicios();
    }

    //Devuelve todos los ejercicios registrados.
    public ArrayList<Ejercicio> obtenerEjercicios() {
        return ejercicios;
    }
    //Busca un ejercicio por su nombre.
    public Ejercicio buscarEjercicio(String nombre) {
        for (Ejercicio ejercicio : ejercicios) {
            if (ejercicio.getNombre().equalsIgnoreCase(nombre)) {
                return ejercicio;
            }
        }
        return null;
    }
    
    //Permite agregar un nuevo ejercicio al catálogo.
    public void agregarEjercicio(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
    }
    
    //Elimina un ejercicio del catálogo.
    public void eliminarEjercicio(Ejercicio ejercicio) {
        ejercicios.remove(ejercicio);
    }

    //Abre el video de YouTube asociado al ejercicio.
    public void abrirVideo(Ejercicio ejercicio) {
        try {
            Desktop.getDesktop().browse(new URI(
                    ejercicio.getLinkYoutube()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
