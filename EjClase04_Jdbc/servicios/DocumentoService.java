package servicios;

import model.Documento;
import repository.DocumentoRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


}
