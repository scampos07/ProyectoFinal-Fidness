package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializador {

    //Guarda un objeto en un archivo.
    public static void guardar(String ruta, Object objeto) {
        try (ObjectOutputStream salida =
                new ObjectOutputStream(new FileOutputStream(ruta))) {
            salida.writeObject(objeto);
            System.out.println("Archivo guardado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
    //Recupera un objeto almacenado.

    public static Object cargar(String ruta) {
        try (ObjectInputStream entrada =
                new ObjectInputStream(new FileInputStream(ruta))) {
            return entrada.readObject();
        } catch (Exception e) {
            System.out.println("No fue posible cargar el archivo.");
            return null;
        }
    }
}
