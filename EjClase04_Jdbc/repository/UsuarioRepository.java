package repository;

import model.Usuario;

import java.sql.*;

public class UsuarioRepository {

    Connection conexion;

    /**
     * Muestra por consola el listado de los usuarios que se encuentran registrados en la base de datos
     */
    public void listarUsuarios(){ //falta terminar resultset
        Statement stmt;
        String buscarUsuarios;
        ResultSet result = null;

        buscarUsuarios = "SELECT usu.idUsuario, usu.nombreUsuario, tu.descripcion, p.nombre, p.apellido, doc.descripcion  FROM Usuario usu, Persona p, TipoUsuario tu, Documento doc where usu.idPersona = p.idPersona and usu.idTipoUsuario = tu.idTipoUsuario and p.tipoDni = doc.idDocumento";

        try {
            conexion = DbConnection.getConnection();
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscarUsuarios);

            while (result.next()) {
                System.out.println("Id: " + result.getInt(1) + ", Username: " + result.getString(2) + ", Tipo Usuario: " + result.getString(3) + ", Nombre: " + result.getString(4) + ", Apellido: " + result.getString(5) + ", Tipo de dni: " + result.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println("No se puedo establecer conexión con la base de datos");
        }
    }


    /**
     * Permite registrar un nuevo usuario en la base de datos. Valida primero si el mismo ya se encuentra registrado
     */
    public Long registrarUsuario(Usuario usuario){
        Long idUsuario = 0L;
        try {
            conexion = DbConnection.getConnection();
            Statement stmt;
            String agregarUsuario;
            Boolean estaRegistrado = buscarUsuario(usuario);

            if (!estaRegistrado) {
                agregarUsuario = "INSERT INTO Usuario (nombreUsuario, passUsuario, idPersona, idTipoUsuario) VALUES('" + usuario.getNombreUsuario() + "', '"+ usuario.getPassUsuario() + "', '"+ usuario.getIdPersona() + "', '" + usuario.getIdTipoUsuario() + "')";
                try {
                    stmt = conexion.createStatement();
                    PreparedStatement pstmt = conexion.prepareStatement(agregarUsuario, Statement.RETURN_GENERATED_KEYS);

                    int filasAfectadas = pstmt.executeUpdate();

                    if (filasAfectadas > 0) {
                        // Obtener la clave generadas
                        ResultSet generatedKeys = pstmt.getGeneratedKeys();

                        if (generatedKeys.next()) {
                            // Obtener el índice de la fila insertada
                            idUsuario = generatedKeys.getLong(1);
                            //System.out.println(idUsuario);
                        }
                    }
                    System.out.println("El usuario " + usuario.getNombreUsuario() + " se cargó correctamente");
                } catch (SQLException ex) {
                    //System.out.println("El tipo de usuario " + usuario.getNombreUsuario() + " no ha podido ser guardado " + ex);
                }
            } else {
                System.out.println("El tipo de usuario " + usuario.getNombreUsuario() + " ya se encontraba previamente registrado en la base de datos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idUsuario;
    }

    private boolean buscarUsuario(Usuario usuario){
        //falta verificar si el usuario ya esta registrado para que no lo guarde repetido
        return false;
    }
    public void buscarNombreUsuario(String nombreUsuario){
        //conexion = DbConnection.getConnection();
        Statement stmt;
        ResultSet result = null;
        Usuario usuario = new Usuario();
        String buscarNombreUsuario = "SELECT usu.idUsuario, usu.nombreUsuario, tu.descripcion, p.nombre, p.apellido, doc.descripcion  FROM Usuario usu, Persona p, TipoUsuario tu, Documento doc where usu.idPersona = p.idPersona and usu.idTipoUsuario = tu.idTipoUsuario and p.tipoDni = doc.idDocumento and usu.nombreUsuario='"+nombreUsuario+"'";

        try {
            conexion = DbConnection.getConnection();
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscarNombreUsuario);

            if(result.next()) {
                System.out.println("Id: " + result.getInt(1) + ", Username: " + result.getString(2) + ", Tipo Usuario: " + result.getString(3) + ", Nombre: " + result.getString(4) + ", Apellido: " + result.getString(5) + ", Tipo de dni: " + result.getString(6));
            }else{
                System.out.println("No se encontró al usuario " + nombreUsuario);
            }
        } catch (SQLException ex) {
            System.out.println("No se puedo establecer conexión con la base de datos");
        }

    }

}
