package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Calendario implements Serializable {

    private ArrayList<ClaseGym> listaClases;
    
    //Constructor.
    public Calendario() {
        listaClases = new ArrayList<>();
    }
    //Agrega una nueva clase al calendario.
    public void agregarClase(ClaseGym claseGym) {
        listaClases.add(claseGym);
    }
    //Devuelve todas las clases registradas.
    public ArrayList<ClaseGym> getListaClases() {
        return listaClases;
    }
    //Busca una clase según la fecha y hora de inicio.
    public ClaseGym buscarClase(LocalDate fecha,
                                LocalTime hora) {
        for (ClaseGym clase : listaClases) {
            if (clase.getFecha().equals(fecha)
                    && clase.getHoraInicio().equals(hora)) {
                return clase;
            }
        }
        return null;
    }
    //Muestra todas las clases registradas.
    public void mostrarDisponibilidad() {
        System.out.println("\n===== CLASES DISPONIBLES =====");
        if (listaClases.isEmpty()) {
            System.out.println("No existen clases registradas.");
            return;
        }
        for (ClaseGym clase : listaClases) {
            System.out.println(clase);
        }
    }
    /**
     * Genera automáticamente los bloques de clases para una fecha.
     *
     * Horario:
     * 5:00 a.m. - 8:00 p.m.
     *
     * Duración:
     * 1 hora y 30 minutos.
     *
     */
    public void generarHorarios(LocalDate fecha) {
        LocalTime horaInicio = LocalTime.of(5, 0);
        LocalTime horaCierre = LocalTime.of(20, 0);
        while (horaInicio.plusMinutes(90).compareTo(horaCierre) <= 0) {
            ClaseGym clase = new ClaseGym(
                    fecha,
                    horaInicio,
                    horaInicio.plusMinutes(90));
            listaClases.add(clase);
            horaInicio = horaInicio.plusMinutes(90);
        }
    }
}
