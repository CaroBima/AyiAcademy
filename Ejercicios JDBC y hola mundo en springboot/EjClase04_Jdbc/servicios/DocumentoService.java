package servicios;

import model.Documento;
import repository.DocumentoRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Servicio que proporciona métodos para obtener información sobre los tipos de documentos
 *
 */
public class DocumentoService {
    DocumentoRepository docuRepo = new DocumentoRepository();


    /**
     * Registra un nuevo tipo de documento
     * @throws IOException
     */
    public void registrarDocumento() throws IOException {
        Documento documento = new Documento();
        documento = cargarNuevoDocumento();
        docuRepo.registrarDocumento(documento);
    }

    /**
     * Método que permite mostrar los tipos de documentos que se encuentran almacenados en la base de datos
     */
    public void listarDocumentos(){
        docuRepo.listarTiposDocumentos();
    }

    /**
     * Permite cargar un nuevo tipo de documento por teclado
     * @return Documento - retorna el documento cargado
     * @throws IOException
     */
    private Documento cargarNuevoDocumento() throws IOException {
        Documento nuevoDoc = new Documento();
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese el nuevo tipo de documento: ");
        String descripcion = entrada.readLine();

        nuevoDoc.setDescripcion(descripcion);

        return nuevoDoc;
    }

    public boolean existeTipoDocumento(Long idDocumento){
        DocumentoRepository documentoRepository = new DocumentoRepository();
        return documentoRepository.buscarTipoDocumento(idDocumento);
    }

}
