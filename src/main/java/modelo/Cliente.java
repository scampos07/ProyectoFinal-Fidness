/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Usuario implements Serializable {

    private TipoMembresia tipoMembresia;
    private ArrayList<Rutina> listaRutinas;
    private ArrayList<Reserva> listaReservas;

    public Cliente(String nombre,
                   String username,
                   String password,
                   TipoMembresia tipoMembresia) {
        super(nombre, username, password);
        this.tipoMembresia = tipoMembresia;
        this.listaRutinas = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
    }

    @Override
    public void mostrarMenu() {

        System.out.println("===== MENÚ CLIENTE =====");
        System.out.println("1. Consultar ejercicios");
        System.out.println("2. Crear rutina");
        System.out.println("3. Ver rutinas");
        System.out.println("4. Reservar clase");
        System.out.println("5. Mis reservas");
    }
    public void agregarRutina(Rutina rutina) {

        listaRutinas.add(rutina);
    }
    public void agregarReserva(Reserva reserva) {
        listaReservas.add(reserva);
    }
    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }
    public void setTipoMembresia(TipoMembresia tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }
    public ArrayList<Rutina> getListaRutinas() {
        return listaRutinas;
    }
    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }
} 
    

