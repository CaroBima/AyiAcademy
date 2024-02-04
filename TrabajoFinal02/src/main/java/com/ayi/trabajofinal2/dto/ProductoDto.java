package com.ayi.trabajofinal2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO que representa un producto
 * Contiene los detalles del producto: codigo Ean, nombre, descripción, tipo, marca, precio y stock del mismo.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {
    private String codigoEan;
    private String nombreProducto;
    private String descripcionProducto;
    private String tipo;
    private String marca;
    private float precio;
    private int stock;
}
