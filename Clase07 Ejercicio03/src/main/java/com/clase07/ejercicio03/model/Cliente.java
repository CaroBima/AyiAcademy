package com.clase07.ejercicio03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private int nroCliente;
    private String nombre;
    private String apellido;
    private String domicilio;
    private int telefono;
    private String email;

}
