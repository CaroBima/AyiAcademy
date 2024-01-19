package com.clase09.ejercicio01.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private int idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;
}
