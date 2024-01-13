package repository;

import java.sql.Connection;

public class UsuarioRepository {
    private static Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String urlCompleta = "jdbc:mysql://localhost:3306/usuarios";


}
