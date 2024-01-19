package com.clase09.ejercicio02.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    private int legajo;
    private String nombre;
    private String apellido;

    @ManyToOne
    @JoinColumn(name="nro_sucursal")
    private Sucursal sucursal;
}
