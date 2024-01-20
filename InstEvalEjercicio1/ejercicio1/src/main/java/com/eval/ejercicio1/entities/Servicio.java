package com.eval.ejercicio1.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="servicios")
public class Servicio implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idServicio;
    private int codigoEan;
    private String nombre;
    private String descripcion;
    private float precio;
    private float duracion;
}
