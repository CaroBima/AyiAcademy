package model;

/*
Crear una base de datos simple con 4 tablas:
Usuarios (IdUsuarios, nombre de usuarios, password de usuarios, IdPersona, tipo de usuario),
Personas (IdPersonas, nombres, apellido, tipo de documento, número de documento),
Documentos (Número de documento, descripción)
Tipo de Usuarios (Id tipo de usuario, descripción).
Crear un menú de opciones.
De preferencia utilizar la clase BufferedReader para la lectura de datos por teclado.
 */
public class Usuario {

private Long idUsuario;
private String nombreUsuario;
private String passUsuario;
private Long idPersona;
private Long idTipoUsuario;

//constructores
    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombreUsuario, String passUsuario, Long idPersona, Long idTipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passUsuario = passUsuario;
        this.idPersona = idPersona;
        this.idTipoUsuario = idTipoUsuario;
    }

    //getters y setters

    public Long getIdUsuarios() {
        return idUsuario;
    }

    public void setIdUsuarios(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
}

