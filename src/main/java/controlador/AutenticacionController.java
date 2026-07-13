package controlador;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Usuario;
import modelo.UsuarioNoEncontradoException;
import modelo.TipoMembresia;

public class AutenticacionController {
    
    //Lista de usuarios registrados.
    private ArrayList<Usuario> usuarios;
    
    //Constructor
    public AutenticacionController() {
    usuarios = new ArrayList<>();
    
    // Usuario de prueba
    Cliente clientePrueba = new Cliente(
            "Stive Campos",
            "stive",
            "1234",
            TipoMembresia.ILIMITADA);
    registrarUsuario(clientePrueba);
}
    //Permite agregar usuarios al sistema.
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
   
    //Valida las credenciales del usuario.
    public Usuario iniciarSesion(String username,
                                 String password)
            throws UsuarioNoEncontradoException {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)
                    && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        throw new UsuarioNoEncontradoException(
                "Usuario o contraseña incorrectos.");
    }

    //Devuelve todos los usuarios registrados.
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
