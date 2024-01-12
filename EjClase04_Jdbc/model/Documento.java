package model;

/*
Documentos (Número de documento, descripción)
 */
public class Documento {
    private Long idDocumento;
    private String descripción;

    //constructor
    public Documento() {
    }

    public Documento(Long idDocumento, String descripción) {
        this.idDocumento = idDocumento;
        this.descripción = descripción;
    }

    //getters y setters
    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }
}
