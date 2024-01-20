package com.eval.ejercicio1.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Servicio implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigoServicio;
    private String nombre;
    private String descripcion;
    private float precio;
    private String duracion;
}
