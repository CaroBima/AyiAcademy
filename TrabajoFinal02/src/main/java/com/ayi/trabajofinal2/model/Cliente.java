package com.ayi.trabajofinal2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa una entidad de Cliente
 * Contiene la información referida al cliente: su id, nombre, apellido, fecha de ingreso, domicilio y telefono de contacto
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    private int idCliente;
    private String nombre;
    private String apellido;
    private String fechaIngreso;
    private String domicilio;
    private String telefono;
}
