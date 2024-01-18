package repository;

import model.Documento;
import model.TipoUsuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DocumentoRepository {
    Connection conexion;




    /**
     * Permite registrar un nuevo tipo de documento en la base de datos.
     * Primero verifica si el tipo de documento ya se encuentra almacenado, si no está registrado lo guarda, si ya se encuentra registrado
     * informa que el tipo de documento ya se encuentra guardado en la base de datos
     * @param
     */
    public void registrarDocumento(Documento documento) throws IOException {

        Statement stmt;
        String agregarDocumento;

        Boolean estaRegistrado = buscarDocumento(documento);

        if(!estaRegistrado){
            agregarDocumento = "INSERT INTO Documento (descripcion) VALUES('" + documento.getDescripcion() +"')";

            try {
                conexion = DbConnection.getConnection();
                stmt = conexion.createStatement();
                String st_inserta = agregarDocumento;
                stmt.executeUpdate(st_inserta);
                System.out.println("El tipo de documento " + documento.getDescripcion() + " se cargo correctamente");
            } catch (SQLException ex) {
                ex.getStackTrace();
            }
        }else{
            System.out.println("El tipo de dni " +  documento.getDescripcion()  + " ya se encontraba previamente registrado en la base de datos");
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

        buscarDoc = "SELECT * FROM Documento WHERE descripcion = '" + documento.getDescripcion()+"'";

        try {
            conexion = DbConnection.getConnection();
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

    public boolean buscarTipoDocumento(Long idDocumento){
        Statement stmt;
        String buscarDoc;
        ResultSet result = null;
        boolean tipoDocumentoEsta = false;

        buscarDoc = "SELECT * FROM Documento WHERE idDocumento = '" + idDocumento +"'";

        try {
            conexion = DbConnection.getConnection();
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscarDoc);

            tipoDocumentoEsta=  (result.next()) ? true : false;
        } catch (SQLException ex) {
            //System.out.println("No se puedo establecer conexión con la base de datos");
            ex.getStackTrace();
        }
        return tipoDocumentoEsta;
    }

    /**
     * Método encargado de listar todos los tipos de documentos que se encuentran almacenados en la base de datos
     */
    public void listarTiposDocumentos() {
        Statement stmt;
        String buscarTipoDocumentos;
        ResultSet result = null;
        boolean tipoUsuarioEsta = false;

        buscarTipoDocumentos = "SELECT * FROM Documento";

        try {
            conexion = DbConnection.getConnection();
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscarTipoDocumentos);

            while (result.next()) {
                System.out.println("Id: " + result.getInt(1) + ", Tipo de documento: " + result.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("No se puedo establecer conexión con la base de datos: " + ex);
        }

    }

}
