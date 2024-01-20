package com.eval.ejercicio2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    private int idUsuario;
    private String nombre;
    private String passwordUsuario;
}
