package com.ayi.trabajofinal01.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int legajo;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String cargo;
    private String sucursal;
    private int antiguedadAnios;
}
