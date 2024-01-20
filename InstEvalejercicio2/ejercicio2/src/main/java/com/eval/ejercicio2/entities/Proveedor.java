package com.eval.ejercicio2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="proveedores")
public class Proveedor implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    private int idProveedor;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private String sitioWeb;
    private int estado;

}
