package repository;

import model.Persona;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonaRepository {
    Connection conexion;

    /**
     * Recibe los datos de una persona por parámetro y los guarda en la base de datos
     * @param persona
     */
    public void guardarPersona(Persona persona){
        try {
            conexion = DbConnection.getConnection();
            Statement stmt;
            String agregarTipoUsuario;
            Boolean estaRegistrado = buscarPersona(persona);

            if (!estaRegistrado) {
                agregarTipoUsuario = "INSERT INTO Persona (nombre, apellido, tipoDni, nroDocumento) VALUES('" + persona.getNombre() + "', '"+  persona.getApellido() +"', '"+  persona.getTipoDni() +"', '"+  persona.getNroDocumento() +"')";

                try {
                    stmt = conexion.createStatement();
                    String st_inserta = agregarTipoUsuario;
                    stmt.executeUpdate(st_inserta);
                    System.out.println(persona.getNombre() + " " + persona.getApellido() + " se cargo correctamente");
                } catch (SQLException ex) {
                    System.out.println(persona.getNombre() + " " + persona.getApellido() + " no han podido ser guardado");
                }
            } else {
                System.out.println(persona.getNombre() + " " + persona.getApellido() + " ya se encontraba previamente registrado en la base de datos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permite realizar la busqueda de una persona en la base de datos.
     * Realiza la busqueda comparando el nombre, apellido y nro de documento con los almancenados en la bbdd
     * Devuelve true en caso de que el usuario se encuentre almacenado y false en caso de que no.
     * @param persona
     * @return boolean
     */
    public boolean buscarPersona(Persona persona){
        String busquedaPersona = "Select * from persona where nombre='" + persona.getNombre() + "' and apellido ='" + persona.getApellido() + "' and nroDocumento='"+ persona.getNroDocumento()+"'";
        ResultSet result = null;
        Statement stmt;
        boolean PersonaEsta = false;

        try {
            stmt = conexion.createStatement();
            result = stmt.executeQuery(busquedaPersona);

            if (result.next()) {
                PersonaEsta = true;
            } else {
                PersonaEsta = false;
            }
        } catch (SQLException ex) {
            System.out.println("No se puedo establecer conexión con la base de datos");
        }

        return PersonaEsta;
    }
}
