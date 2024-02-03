package com.ayi.trabajofinal2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad Usuario, utilizada para validar el acceso a la aplicacion
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    private int idUsuario;
    private String nombreUsuario;
    private String passwordUsuario;
}
