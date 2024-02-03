package com.ayi.trabajofinal2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
