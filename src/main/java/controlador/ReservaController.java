package controlador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.AforoMaximoException;
import modelo.ClaseGym;
import modelo.Cliente;
import modelo.Reserva;
import modelo.TipoMembresia;
import persistencia.Serializador;

public class ReservaController implements Serializable {
    private ArrayList<Reserva> reservas;
    private static final String ARCHIVO = "reservas.dat";
    /**
     * Constructor.
     * Intenta cargar las reservas almacenadas.
     */
    @SuppressWarnings("unchecked")
    public ReservaController() {
        Object datos = Serializador.cargar(ARCHIVO);
        if (datos != null) {
            reservas = (ArrayList<Reserva>) datos;
        } else {
            reservas = new ArrayList<>();
        }
    }

    //Registra una nueva reserva.
    public void realizarReserva(Cliente cliente,
                                ClaseGym clase)
            throws Exception {
        validarMembresia(cliente);
        clase.agregarParticipante(cliente);
        Reserva reserva = new Reserva(
                cliente,
                clase,
                LocalDate.now());
        reservas.add(reserva);
        cliente.agregarReserva(reserva);
        guardarReservas();
    }

    //Valida las restricciones según el tipo de membresía.
    private void validarMembresia(Cliente cliente)
            throws Exception {
        TipoMembresia membresia = cliente.getTipoMembresia();
        int reservasSemana = contarReservasSemana(cliente);
        int reservasHoy = contarReservasHoy(cliente);
        switch (membresia) {
            case BASICA:
                if (reservasSemana >= 2) {
                    throw new Exception(
                            "Su membresía básica permite únicamente 2 reservas por semana.");
                }
                if (reservasHoy >= 1) {
                    throw new Exception(
                            "Solo puede realizar una reserva por día.");
                }
                break;
            case INTERMEDIA:
                if (reservasSemana >= 4) {
                    throw new Exception(
                            "Su membresía intermedia permite únicamente 4 reservas por semana.");
                }
                if (reservasHoy >= 1) {
                    throw new Exception(
                            "Solo puede realizar una reserva por día.");
                }
                break;
            case ILIMITADA:
                // No posee restricciones.
                break;
        }
    }

    //Cuenta las reservas del día.
    private int contarReservasHoy(Cliente cliente) {
        int contador = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente)
                    &&
                reserva.getFechaReserva().equals(LocalDate.now())) {
                contador++;
            }
        }
        return contador;
    }
    
    //Cuenta las reservas de la semana.
    private int contarReservasSemana(Cliente cliente) {
        int contador = 0;
        LocalDate inicioSemana = LocalDate.now().minusDays(6);
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente)
                    &&
                !reserva.getFechaReserva().isBefore(inicioSemana)) {
                contador++;
            }
        }
        return contador;
    }

    //Cancela una reserva existente.
    public void cancelarReserva(Reserva reserva) {
        reserva.getClaseGym()
                .eliminarParticipante(reserva.getCliente());
        reservas.remove(reserva);
        guardarReservas();
    }
    
    //Devuelve todas las reservas registradas.
    public ArrayList<Reserva> obtenerReservas() {
        return reservas;
    }
   
    //Guarda las reservas utilizando serialización.
    public void guardarReservas() {
        Serializador.guardar(ARCHIVO, reservas);
    }
}
