package com.ayi.trabajofinal2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa una entidad de producto en el sistema.
 * Contiene información detallada sobre un producto específico: id del producto, código EAN, nombre del producto, descripción
 * tipo, marca, precio y stock.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    private int idProducto;
    private String codigoEan;
    private String nombreProducto;
    private String descripcionProducto;
    private String tipo;
    private String marca;
    private float precio;
    private int stock;
}
