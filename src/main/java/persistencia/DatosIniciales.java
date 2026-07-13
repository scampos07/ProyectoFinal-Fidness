package persistencia;

import java.util.ArrayList;
import modelo.Ejercicio;
import modelo.GrupoMuscular;
import modelo.NivelRutina;
import modelo.Rutina;

public class DatosIniciales {
    
    //Crea los ejercicios disponibles en el sistema.
    public static ArrayList<Ejercicio> cargarEjercicios() {
        ArrayList<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(new Ejercicio(
                1,
                "Sentadilla",
                GrupoMuscular.PIERNA,
                "Ejercicio para fortalecer piernas y glúteos.",
                "https://www.youtube.com/watch?v=ultWZbUMPL8"));
        ejercicios.add(new Ejercicio(
                2,
                "Press de banca",
                GrupoMuscular.PECHO,
                "Ejercicio para desarrollar el pecho.",
                "https://www.youtube.com/watch?v=rT7DgCr-3pg"));
        ejercicios.add(new Ejercicio(
                3,
                "Peso muerto",
                GrupoMuscular.ESPALDA,
                "Ejercicio compuesto para espalda y piernas.",
                "https://www.youtube.com/watch?v=ytGaGIn3SjE"));
        ejercicios.add(new Ejercicio(
                4,
                "Dominadas",
                GrupoMuscular.ESPALDA,
                "Ejercicio para espalda y bíceps.",
                "https://www.youtube.com/watch?v=eGo4IYlbE5g"));
        ejercicios.add(new Ejercicio(
                5,
                "Curl de bíceps",
                GrupoMuscular.BRAZO,
                "Ejercicio para fortalecer bíceps.",
                "https://www.youtube.com/watch?v=ykJmrZ5v0Oo"));
        ejercicios.add(new Ejercicio(
                6,
                "Press militar",
                GrupoMuscular.HOMBRO,
                "Ejercicio para fortalecer hombros.",
                "https://www.youtube.com/watch?v=qEwKCR5JCog"));
        ejercicios.add(new Ejercicio(
                7,
                "Crunch abdominal",
                GrupoMuscular.ABDOMEN,
                "Ejercicio para trabajar el abdomen.",
                "https://www.youtube.com/watch?v=Xyd_fa5zoEU"));
        return ejercicios;
    }
    //Crea las tres rutinas predeterminadas del sistema.
    public static ArrayList<Rutina> cargarRutinas() {
        ArrayList<Ejercicio> ejercicios = cargarEjercicios();
        ArrayList<Rutina> rutinas = new ArrayList<>();

        // Rutina Principiante
        Rutina principiante =
                new Rutina(
                        "Rutina Principiante",
                        NivelRutina.PRINCIPIANTE);
        principiante.agregarEjercicio(ejercicios.get(0));
        principiante.agregarEjercicio(ejercicios.get(1));
        principiante.agregarEjercicio(ejercicios.get(6));

        rutinas.add(principiante);
        
        // Rutina Intermedia
        Rutina intermedia =
                new Rutina(
                        "Rutina Intermedia",
                        NivelRutina.INTERMEDIO);
        intermedia.agregarEjercicio(ejercicios.get(2));
        intermedia.agregarEjercicio(ejercicios.get(4));
        intermedia.agregarEjercicio(ejercicios.get(5));

        rutinas.add(intermedia);
        
        // Rutina Avanzada
        Rutina avanzada =
                new Rutina(
                        "Rutina Avanzada",
                        NivelRutina.AVANZADO);
        avanzada.agregarEjercicio(ejercicios.get(0));
        avanzada.agregarEjercicio(ejercicios.get(2));
        avanzada.agregarEjercicio(ejercicios.get(3));
        avanzada.agregarEjercicio(ejercicios.get(5));
        rutinas.add(avanzada);
        return rutinas;
    }
}
