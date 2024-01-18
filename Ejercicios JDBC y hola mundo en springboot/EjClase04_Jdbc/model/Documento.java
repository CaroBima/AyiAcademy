package model;


public class Documento {
    private Long idDocumento;
    private String descripcion;

    //constructor
    public Documento() {
    }

    public Documento(Long idDocumento, String descripcion) {
        this.idDocumento = idDocumento;
        this.descripcion = descripcion;
    }

    //getters y setters
    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
