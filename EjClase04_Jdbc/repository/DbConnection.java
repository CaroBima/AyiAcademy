package repository;

import model.Documento;
import model.TipoUsuario;

import java.sql.*;

public class DbConnection {
    private static Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String db = "usuarios";
    private static final String url = "jdbc:mysql://localhost:3306/"+db+"";


    /**
     * Método constructor (vacío) de la clase conexion, es el que hace la conexión con la bbdd.
     * En el caso de que la base de datos no exista la crea y crea también las tablas
     */
    public DbConnection() {
        try {
            Statement s;
            Class.forName(driver);

            conexion = (Connection) DriverManager.getConnection(url,user,pass);
            s = conexion.createStatement();

            s.executeUpdate("CREATE DATABASE IF NOT EXISTS USUARIOS");
            crearTablas();
            s.close();
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException ex) {
            System.out.println("No se pudo establecer la conexión con la base de datos");
        }
    }

    /**
     * Método que crea las tablas de la base de datos en caso de que no existan
     */
    public void crearTablas() throws SQLException {
        Statement s;
        try {
            s = conexion.createStatement();

            s.executeUpdate("CREATE TABLE IF NOT EXISTS TipoUsuario (idTipoUsuario BIGINT(20) AUTO_INCREMENT, PRIMARY KEY(idTipoUsuario), descripcion VARCHAR(200))");
            //System.out.println("La tabla \"TipoUsuario\" ha sido creada correctamente");

            s.executeUpdate("CREATE TABLE IF NOT EXISTS Documento (idDocumento BIGINT(20) AUTO_INCREMENT, PRIMARY KEY(idDocumento), descripcion VARCHAR(200))");
            //System.out.println("La tabla \"Documento\" ha sido creada correctamente");

            s.executeUpdate("CREATE TABLE IF NOT EXISTS Persona (idPersona BIGINT(20) AUTO_INCREMENT, PRIMARY KEY(idPersona), nombre VARCHAR(80), apellido VARCHAR(80), tipoDni BIGINT(20), FOREIGN KEY(tipoDni) REFERENCES Documento(idDocumento), nroDocumento VARCHAR(30) )");
            //System.out.println("La tabla \"Persona\" ha sido creada correctamente");

            s.executeUpdate("CREATE TABLE IF NOT EXISTS Usuario (idUsuario BIGINT(20) AUTO_INCREMENT, PRIMARY KEY(idUsuario), nombreUsuario VARCHAR(80), passUsuario VARCHAR(80), idPersona BIGINT(20), FOREIGN KEY( idPersona) REFERENCES Persona(idPersona), idTipoUsuario BIGINT(20), FOREIGN KEY(idTipoUsuario) REFERENCES TipoUsuario(idTipoUsuario))");
            //System.out.println("La tabla \"USUARIO\" ha sido creada correctamente");
        } catch (SQLException ex) {
            System.out.println("Error al crear las tablas: " + ex);
        }

    }

    /**
     * Permite registrar un nuevo tipo de documento en la base de datos.
     * Primero verifica si el tipo de documento ya se encuentra almacenado, si no está registrado lo guarda, si ya se encuentra registrado
     * informa que el tipo de documento ya se encuentra guardado en la base de datos
     * @param documento
     */
    public void registrarDocumento(Documento documento) {
        Statement stmt;
        String agregarDocumento;
        Boolean estaRegistrado = buscarDocumento(documento);

        if(!estaRegistrado){
            agregarDocumento = "INSERT INTO Documento (descripcion) VALUES('" + documento.getDescripción() +"')";

            try {
                stmt = conexion.createStatement();
                String st_inserta = agregarDocumento;
                stmt.executeUpdate(st_inserta);
                System.out.println("El tipo de documento " + documento.getDescripción() + " se cargo correctamente");
            } catch (SQLException ex) {
                System.out.println("El tipo de dni " +  documento.getDescripción()  + " no han podido ser guardado");
            }
        }else{
            System.out.println("El tipo de dni " +  documento.getDescripción()  + " ya se encontraba previamente registrado en la base de datos");
        }
    }

    /**
     * Permite registrar un nuevo tipo de usuario en la base de datos.
     * Primero verifica si el tipo de usuario ya se encuentra almacenado, si no está registrado lo guarda, si ya se encuentra registrado
     * Una vez que lo guarda informa que se hizo el cambio, si no se puede guardar lo informa también.
     * @param tipoUsuario
     */
    public void registrarTipoUsuario(TipoUsuario tipoUsuario) {
        Statement stmt;
        String agregarTipoUsuario;
        Boolean estaRegistrado = buscarTipoUsuario(tipoUsuario.getDescripcion());

        if(!estaRegistrado){
            agregarTipoUsuario = "INSERT INTO TipoUsuario (descripcion) VALUES('" + tipoUsuario.getDescripcion() +"')";

            try {
                stmt = conexion.createStatement();
                String st_inserta = agregarTipoUsuario;
                stmt.executeUpdate(st_inserta);
                System.out.println("El tipo de usuario " + tipoUsuario.getDescripcion() + " se cargo correctamente");
            } catch (SQLException ex) {
                System.out.println("El tipo de usuario " +  tipoUsuario.getDescripcion()  + " no han podido ser guardado");
            }
        }else{
            System.out.println("El tipo de usuario " +  tipoUsuario.getDescripcion()  + " ya se encontraba previamente registrado en la base de datos");
        }
    }

    /**
     * Verifica si el documento que recibe por parámetros ya está en la base de datos. Devuelve true en caso de que este y false si no está.
     * @param documento
     * @return boolean
     */
    public boolean buscarDocumento(Documento documento){
        Statement stmt;
        String buscarDoc;
        ResultSet result = null;
        boolean documentoEsta = false;

        buscarDoc = "SELECT * FROM Documento WHERE descripción = '" + documento.getDescripción();

        try {
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscarDoc);

            if (result.next()){
                documentoEsta = true;
            }
            else{
                documentoEsta = false;
            }
        } catch (SQLException ex) {
            System.out.println("No se puedo establecer conexión con la base de datos");
        }
        return documentoEsta;
    }

    /**
     * Permite buscar un determinado tipo de usuario para ver si se encuentra ya guardado en la base de datos
     * realiza la busqueda por el tipo de usuario
     * @param tipoUsuario
     * @return
     */
    public boolean buscarTipoUsuario(String tipoUsuario){
        Statement stmt;
        String buscarTipoUsuario;
        ResultSet result = null;
        boolean tipoUsuarioEsta = false;

        buscarTipoUsuario = "SELECT * FROM Documento WHERE descripción = '" + tipoUsuario;

        try {
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscarTipoUsuario);

            if (result.next()){
                tipoUsuarioEsta = true;
            }
            else{
                tipoUsuarioEsta = false;
            }
        } catch (SQLException ex) {
            System.out.println("No se puedo establecer conexión con la base de datos");
        }
        return tipoUsuarioEsta;
    }

    /**
     * Lista por consola los tipos de usuarios que se encuentran registrados en la base de datos
     */
    public void listarTipoUsuario(){
        Statement stmt;
        String buscarTipoUsuario;
        ResultSet result = null;
        boolean tipoUsuarioEsta = false;

        buscarTipoUsuario = "SELECT * FROM TipoUsuario";

        try {
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscarTipoUsuario);

            while(result.next()){
                System.out.println("Id: " + result.getInt(1) + ", Tipo de usuario: " + result.getString(2));
            }

        } catch (SQLException ex) {
            System.out.println("No se puedo establecer conexión con la base de datos");
        }

    }


}
