package model;

/*Tipo de Usuarios (Id tipo de usuario, descripción).*/

public class TipoUsuario {
    private Long idTipoUsuario;
    private String descripcion;

    //constructor

    public TipoUsuario() {
    }

    public TipoUsuario(Long idTipoUsuario, String descripcion) {
        this.idTipoUsuario = idTipoUsuario;
        this.descripcion = descripcion;
    }

    //getters y setters
    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
