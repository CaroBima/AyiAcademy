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
     * Valida si la persona se encuentra ya guardada y si no lo está la guarda (la validación se hace buscando por nombre,
     * apellido y dni)
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

    public Long buscarIdPersona(Persona persona){
        String busquedaPersona = "Select idPersona from persona where nombre='" + persona.getNombre() + "' and apellido ='" + persona.getApellido() + "' and nroDocumento='"+ persona.getNroDocumento()+"'";
        ResultSet result = null;
        Statement stmt;
        Long idPersona = 0L;

        try {
            stmt = conexion.createStatement();
            result = stmt.executeQuery(busquedaPersona);

            if (result.next()) {
                idPersona = result.getLong(1);
            } else {
                idPersona = 0L;
            }
        } catch (SQLException ex) {
            System.out.println("No se puedo establecer conexión con la base de datos");
        }
        return idPersona;
    }
}
