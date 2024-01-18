package repository;

import model.TipoUsuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TipoUsuarioRepository {
    Connection conexion;

    public TipoUsuarioRepository() {
    }

    /**
     * Permite registrar un nuevo tipo de usuario en la base de datos.
     * Primero verifica si el tipo de usuario ya se encuentra almacenado, si no está registrado lo guarda, si ya se encuentra registrado
     * Una vez que lo guarda informa que se hizo el cambio, si no se puede guardar lo informa también.
     *
     * @param tipoUsuario
     */
    public void registrarTipoUsuario(TipoUsuario tipoUsuario) {

        try {
            conexion = DbConnection.getConnection();
            Statement stmt;
            String agregarTipoUsuario;
            Boolean estaRegistrado = buscarTipoUsuario(tipoUsuario.getDescripcion());

            if (!estaRegistrado) {
                agregarTipoUsuario = "INSERT INTO TipoUsuario (descripcion) VALUES('" + tipoUsuario.getDescripcion() + "')";

                try {
                    stmt = conexion.createStatement();
                    String st_inserta = agregarTipoUsuario;
                    stmt.executeUpdate(st_inserta);
                    System.out.println("El tipo de usuario " + tipoUsuario.getDescripcion() + " se cargo correctamente");
                } catch (SQLException ex) {
                    //System.out.println("El tipo de usuario " + tipoUsuario.getDescripcion() + " no han podido ser guardado");
                    ex.getStackTrace();
                }
            } else {
                System.out.println("El tipo de usuario " + tipoUsuario.getDescripcion() + " ya se encontraba previamente registrado en la base de datos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * Permite buscar un determinado tipo de usuario para ver si se encuentra ya guardado en la base de datos
     * realiza la busqueda por el tipo de usuario
     *
     * @param tipoUsuario
     * @return
     */
    public boolean buscarTipoUsuario(String tipoUsuario) {
        Statement stmt;
        String buscarTipoUsuario;
        ResultSet result = null;
        boolean tipoUsuarioEsta = false;

        buscarTipoUsuario = "SELECT * FROM Documento WHERE descripcion = '" + tipoUsuario + "'";

        try {
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscarTipoUsuario);

            if (result.next()) {
                tipoUsuarioEsta = true;
            } else {
                tipoUsuarioEsta = false;
            }
        } catch (SQLException ex) {
            System.out.println("No se puedo establecer conexión con la base de datos: " + ex );
        }
        return tipoUsuarioEsta;
    }

    /**
     * Lista por consola los tipos de usuarios que se encuentran registrados en la base de datos
     */
    public void listarTipoUsuario() {
        Statement stmt;
        String buscarTipoUsuario;
        ResultSet result = null;
        boolean tipoUsuarioEsta = false;

        buscarTipoUsuario = "SELECT * FROM TipoUsuario";

        try {
            conexion = DbConnection.getConnection();
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscarTipoUsuario);

            while (result.next()) {
                System.out.println("Id: " + result.getInt(1) + ", Tipo de usuario: " + result.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("No se puedo establecer conexión con la base de datos: " + ex);
        }
    }

    /**
     * Método que permite buscar un id de tipo de usuario para verificar si existe en la base de datos
     * Devuelve true si está y false si no se encontró.
     * @param idTipoUsuario
     * @return
     */
    public boolean existeTipoUsuario(Long idTipoUsuario){
        Statement stmt;
        String buscaridTipoUsuario;
        ResultSet result = null;
        boolean tipoUsuarioEsta = false;

        buscaridTipoUsuario = "SELECT * FROM TipoUsuario where idTipoUsuario="+ idTipoUsuario;

        try {
            conexion = DbConnection.getConnection();
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscaridTipoUsuario);

            tipoUsuarioEsta = (result.next()) ? true : false;

        } catch (SQLException ex) {
            System.out.println("No se puedo establecer conexión con la base de datos: " + ex);
        }
        return tipoUsuarioEsta;
    }
}