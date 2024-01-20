package com.eval.ejercicio1.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="productos")
public class Producto implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int idProducto;
    private int codigoEan;
    private String nombre;
    private String descripcion;
    private float precio;
    private int stock;
}
