package com.eval.ejercicio1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigoProducto;
    private int codigoEan;
    private String nombre;
    private String descripcion;
    private float precio;
    private String duracion;
}
