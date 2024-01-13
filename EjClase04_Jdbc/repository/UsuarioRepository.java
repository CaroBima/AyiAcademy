package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioRepository {

    Connection conexion;

    public void listarUsuarios(){ //falta terminar resultset
        Statement stmt;
        String buscarUsuarios;
        ResultSet result = null;

        buscarUsuarios = "SELECT * FROM Usuario";

        try {
            conexion = DbConnection.getConnection();
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscarUsuarios);

            while (result.next()) {
                System.out.println("Id: " + result.getInt(1) + ", Tipo de usuario: " + result.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("No se puedo establecer conexión con la base de datos");
        }

    }


}
