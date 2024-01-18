package com.clase06.ejercicio02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Integer nroCliente;
    private String nombre;
    private String apellido;
    private String telefono;

}
