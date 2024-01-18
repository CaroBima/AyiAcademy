package com.clase06.ejercicio03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    private int legajo;
    private String nombre;
    private String apellido;
    private int antiguedad;
}
