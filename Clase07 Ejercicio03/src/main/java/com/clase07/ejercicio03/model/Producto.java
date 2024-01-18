package com.clase07.ejercicio03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private String marca;
    private Float precio;


}
