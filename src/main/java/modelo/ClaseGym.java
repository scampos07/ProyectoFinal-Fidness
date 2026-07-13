package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ClaseGym implements Serializable {
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    private final int capacidadMaxima = 20;
    private ArrayList<Cliente> participantes;
    //Constructor de la clase.
    public ClaseGym(LocalDate fecha,
                    LocalTime horaInicio,
                    LocalTime horaFin) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        participantes = new ArrayList<>();
    }
    /**
     * Agrega un participante a la clase.
     *
     * Si la clase ya alcanzó los 20 participantes,
     * se lanza una excepción personalizada.
     */
    public void agregarParticipante(Cliente cliente)
            throws AforoMaximoException {
        if (participantes.size() >= capacidadMaxima) {
            throw new AforoMaximoException(
                    "AFORO MÁXIMO - INTENTE EN OTRO HORARIO");
        }
        participantes.add(cliente);
    }
    //Permite cancelar la reserva de un cliente.
    public void eliminarParticipante(Cliente cliente) {
        participantes.remove(cliente);
    }
    //Devuelve la cantidad de espacios disponibles.
    public int getCuposDisponibles() {

        return capacidadMaxima - participantes.size();
    }
    // Indica si la clase aún tiene espacios disponibles.

    public boolean hayCupoDisponible() {
        return participantes.size() < capacidadMaxima;
    }
    // Getters y Setters
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    public LocalTime getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    public ArrayList<Cliente> getParticipantes() {
        return participantes;
    }
    /**
     * Devuelve un texto amigable para mostrar la clase
     * dentro de listas y JComboBox.
     */
    @Override
    public String toString() {
        return fecha + " | "
                + horaInicio + " - "
                + horaFin
                + " | Cupos: "
                + getCuposDisponibles();
    }
}