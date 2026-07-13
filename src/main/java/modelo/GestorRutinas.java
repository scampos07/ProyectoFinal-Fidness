package modelo;
/**
 *
 * @author E1485881
 */

import java.util.ArrayList;

public class GestorRutinas {
    private ArrayList<Rutina> listaRutinasSistema;
    public GestorRutinas() {
        listaRutinasSistema = new ArrayList<>();
    }
    public void agregarRutina(Rutina rutina) {
        listaRutinasSistema.add(rutina);
    }
    public ArrayList<Rutina> getListaRutinasSistema() {
        return listaRutinasSistema;
    }
}