package com.ayi.trabajofinal01.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int legajo;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String cargo;
    private String sucursal;
    private int antiguedadAnios;
}
