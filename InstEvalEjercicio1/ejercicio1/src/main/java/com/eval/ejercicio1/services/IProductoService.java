package com.eval.ejercicio1.services;

import com.eval.ejercicio1.entities.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> obtenerProductos();
    Producto guardarProducto(Producto producto);
    void borrarProductoPorId(String idProducto);


}
