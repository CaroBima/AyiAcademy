package com.ayi.trabajofinal2.services;


import com.ayi.trabajofinal2.dto.ProductoDto;
import com.ayi.trabajofinal2.model.Producto;

import java.util.List;

/**
 * Interfaz que permite gestionar los productos, proporcionando operaciones para consultar el listado de productos,
 * guardar un nuevo producto, editarlo o eliminarlo
 *
 */
public interface IProductoService {
    List<Producto> getListaProductos();

    boolean guardar(ProductoDto productoDto);
    boolean editar (Producto producto);
    boolean borrar (String idProducto);
}
