package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable {
    private Cliente cliente;
    private ClaseGym claseGym;
    private LocalDate fechaReserva;
    
    //Constructor de la clase Reserva.
    public Reserva(Cliente cliente,
                   ClaseGym claseGym,
                   LocalDate fechaReserva) {
        this.cliente = cliente;
        this.claseGym = claseGym;
        this.fechaReserva = fechaReserva;
    }
    /**
     * Confirma la reserva del cliente.
     *
     * En futuras versiones este método validará las restricciones
     * según el tipo de membresía.
     */
    public void confirmarReserva() {
        System.out.println("Reserva confirmada para " + cliente.getNombre());
    }
    //Cancela una reserva previamente realizada.
    public void cancelarReserva() {
        System.out.println("Reserva cancelada.");
    }
    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public ClaseGym getClaseGym() {
        return claseGym;
    }
    public void setClaseGym(ClaseGym claseGym) {
        this.claseGym = claseGym;
    }
    public LocalDate getFechaReserva() {
        return fechaReserva;
    }
    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    //Devuelve una descripción amigable de la reserva.
    @Override
    public String toString() {
        return cliente.getNombre()
                + " | "
                + claseGym.getFecha()
                + " | "
                + claseGym.getHoraInicio();
    }
}
