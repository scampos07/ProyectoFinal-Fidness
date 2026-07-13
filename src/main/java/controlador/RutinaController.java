package controlador;

import java.util.ArrayList;

import modelo.Rutina;
import persistencia.DatosIniciales;
import persistencia.Serializador;

public class RutinaController {

    //Lista de rutinas disponibles.
    private ArrayList<Rutina> rutinas;

    //Nombre del archivo donde se almacenarán las rutinas.
    private static final String ARCHIVO = "rutinas.dat";

    /**
     * Constructor
     Primero intenta cargar las rutinas almacenadas
     Si no existe un archivo, carga las rutinas
     predeterminadas del sistema
     */
    @SuppressWarnings("unchecked")
    public RutinaController() {
        Object datos = Serializador.cargar(ARCHIVO);
        if (datos != null) {
            rutinas = (ArrayList<Rutina>) datos;
        } else {
            rutinas = DatosIniciales.cargarRutinas();
        }
    }
    //Devuelve todas las rutinas disponibles
    public ArrayList<Rutina> obtenerRutinas() {
        return rutinas;
    }
    //Agrega una nueva rutina
    public void agregarRutina(Rutina rutina) {
        rutinas.add(rutina);
        guardarRutinas();
    }

    //Elimina una rutina
    public void eliminarRutina(Rutina rutina) {
        rutinas.remove(rutina);
        guardarRutinas();
    }
    //Busca una rutina por su nombre
    public Rutina buscarRutina(String nombre) {
        for (Rutina rutina : rutinas) {
            if (rutina.getNombreRutina().equalsIgnoreCase(nombre)) {
                return rutina;
            }
        }
        return null;
    }
    
    //Guarda todas las rutinas utilizando serialización
    public void guardarRutinas() {
        Serializador.guardar(ARCHIVO, rutinas);
    }
    
    //Recarga las rutinas almacenadas
    @SuppressWarnings("unchecked")
    public void cargarRutinas() {
        Object datos = Serializador.cargar(ARCHIVO);
        if (datos != null) {
            rutinas = (ArrayList<Rutina>) datos;
        }
    }
}
