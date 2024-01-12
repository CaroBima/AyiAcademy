package model;

/*
Personas (IdPersonas, nombres, apellido, tipo de documento, número de documento),
 */
public class Persona {
    private Long idPersona;
    private String nombre;
    private String apellido;
    private Long tipoDni;
    private String nroDocumento;

    //Constructores
    public Persona() {
    }

    public Persona(Long idPersona, String nombre, String apellido, Long tipoDni, String nroDocumento) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDni = tipoDni;
        this.nroDocumento = nroDocumento;
    }

    //getters y setters

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(Long tipoDni) {
        this.tipoDni = tipoDni;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }
}
