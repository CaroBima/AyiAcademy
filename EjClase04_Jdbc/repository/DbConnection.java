package repository;

import model.Documento;
import model.TipoUsuario;

import java.sql.*;

public class DbConnection {
    private static Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static String db = "";
    private static final String url = "jdbc:mysql://localhost:3306/"+db+"";
    private static final String urlCompleta = "jdbc:mysql://localhost:3306/usuarios";

    /**
     * Método constructor (vacío) de la clase conexion, es el que hace la conexión con la bbdd.
     * En el caso de que la base de datos no exista la crea y crea también las tablas
     */
    public DbConnection() {
        try {
            Statement s;
            Class.forName(driver);

            //si la base de datos no existe la crea
            conexion = (Connection) DriverManager.getConnection(url,user,pass);
            s = conexion.createStatement();

            s.executeUpdate("CREATE DATABASE IF NOT EXISTS USUARIOS");
            s.close();

            //se conecta a la base de datos
            conexion = (Connection) DriverManager.getConnection(urlCompleta,user,pass);
            s = conexion.createStatement();
            crearTablas();
            s.close();

            //conexion = DriverManager.getConnection(urlCompleta, user, pass);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException ex) {
            System.out.println("No se pudo establecer la conexión con la base de datos");
        }
    }

    /**
     * Permite establecer la conexion desde los repositorios
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(urlCompleta, user, pass);
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
}



