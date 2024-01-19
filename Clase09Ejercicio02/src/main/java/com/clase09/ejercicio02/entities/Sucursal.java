package com.clase09.ejercicio02.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Table(name = "sucursales")
public class Sucursal {
    @Id
    @Column(name = "nro_sucursal")
    private int nroSucursal;
    private String nombre;
    private String direccion;
    private String barrio;
}
