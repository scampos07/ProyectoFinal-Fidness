
package modelo;
import java.io.Serializable;
/**
 * Representa un usuario administrador del sistema.
 * Hereda los atributos y comportamientos básicos de la clase Usuario.
 * Su función principal es administrar ejercicios, clases y usuarios.
 *
 * @author Stive Campos
 */
public class Administrador extends Usuario implements Serializable {

    public Administrador(String nombre,
                         String username,
                         String password) {

        super(nombre, username, password);
    }
/**
     * Implementación del método abstracto definido en Usuario.
     * Demuestra el uso de polimorfismo.
*/
    @Override
    public void mostrarMenu() {
        System.out.println("===== MENÚ ADMINISTRADOR =====");
        System.out.println("1. Administrar ejercicios");
        System.out.println("2. Administrar clases");
        System.out.println("3. Administrar usuarios");
        System.out.println("4. Ver reportes");
    }
    public void agregarEjercicio(Ejercicio ejercicio) {
        System.out.println("Ejercicio agregado: "
                + ejercicio.getNombre());
    }

     //Simula la eliminación de un ejercicio del sistema

    public void eliminarEjercicio(Ejercicio ejercicio) {

        System.out.println("Ejercicio eliminado: "
                + ejercicio.getNombre());
    }
}
