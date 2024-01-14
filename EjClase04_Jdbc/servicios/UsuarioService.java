package servicios;

import model.Persona;
import model.Usuario;
import repository.TipoUsuarioRepository;
import repository.UsuarioRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UsuarioService {

    UsuarioRepository usuarioRepo = new UsuarioRepository();
    /**
     * Permite mostrar el listado de usuarios registrados en la base de datos
     */
    public void listarUsuarios(){
         usuarioRepo.listarUsuarios();
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     * Si el id de usuario es cero, no lo registra
     * @throws IOException
     */
    public void registrarUsuario() throws IOException {
        Usuario usuario = cargarUsuario();
        if(usuario.getIdUsuarios() != 0) {
            usuarioRepo.registrarUsuario(usuario);
        }
    }

    /**
     * Solicita el ingreso del nombre de usuario que se desea buscar y una vez ingresado realiza la busqueda
     */
    public void buscarNombreUsuario() throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese en nombre de usuario que desea buscar: ");
        String nombreUsuario = entrada.readLine();

        usuarioRepo.buscarNombreUsuario(nombreUsuario);


    }


    /**
     * Permite ingresar por teclado los datos de un nuevo usuario
     * @return
     * @throws IOException
     */
    public Usuario cargarUsuario() throws IOException {
        String nombreUsuario;
        String passUsuario;
        Long idTipoUsuario;
        boolean existeTipoUsuario;
        TipoUsuarioService tipoUsuarioService = new TipoUsuarioService();
        PersonaService personaService = new PersonaService();
        Usuario usuario = new Usuario();
        Persona persona;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nombre de usuario: ");
        nombreUsuario = entrada.readLine();
        System.out.print("Contraseña: ");
        passUsuario = entrada.readLine();

        Long idPersona = personaService.cargarPersona();


        do{ //valido si el id del tipo de usuario esta en la base de datos, si no esta vuelve a pedirlo
            System.out.print("Id tipo de usuario (0 para cancelar): ");
            idTipoUsuario = Long.valueOf(entrada.readLine());
            existeTipoUsuario = tipoUsuarioService.existeTipoUsuario(idTipoUsuario);

            if(!existeTipoUsuario)
                System.out.println("El tipo de usuario no existe, por favor intentar nuevamente o 0 para salir");
        }while(!existeTipoUsuario || idTipoUsuario ==0);

        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassUsuario(passUsuario);
        usuario.setIdPersona(idPersona);
        usuario.setIdTipoUsuario(idTipoUsuario);


        return usuario;
    }
}
