package servicios;

import model.TipoUsuario;
import repository.TipoUsuarioRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TipoUsuarioService {


    public TipoUsuarioService() {
    }

    /**
     * Permite realizar la carga de un nuevo tipo de usuario en la base de datos
     * @return tipoUsuario, el nuevo tipo de usuario que será guardado en la base de datos
     * @throws IOException
     */
    public TipoUsuario cargarTipoUsuario() throws IOException {
        TipoUsuario tipoUsuario = new TipoUsuario();
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese la descripción del tipo de usuario: ");
        String descripcion = entrada.readLine();

        tipoUsuario.setDescripcion(descripcion);

        return tipoUsuario;
    }

    /**
     * Metodo que primero realiza la carga del usuario y posteriormente envía la info al repositorio
     * para guardar el nuevo tipo de usuario
     * @throws IOException
     */
    public void registrarTipoUsuario() throws IOException {
        TipoUsuarioRepository tipoUsuRepo = new TipoUsuarioRepository();
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario = cargarTipoUsuario();
        tipoUsuRepo.registrarTipoUsuario(tipoUsuario);
    }

    /**
     * Muestra todos los tipos de usuarios que se encuentran registrados en la base de datos
     */
    public void listarTipoUsuario(){
        TipoUsuarioRepository tipoUsuRepo = new TipoUsuarioRepository();
        tipoUsuRepo.listarTipoUsuario();
    }


    public boolean existeTipoUsuario(Long idTipoUsuario){
        TipoUsuarioRepository tipoUsuRepo = new TipoUsuarioRepository();
        return tipoUsuRepo.existeTipoUsuario(idTipoUsuario);
    }
}
