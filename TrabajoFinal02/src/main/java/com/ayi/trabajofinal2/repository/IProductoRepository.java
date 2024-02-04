package com.ayi.trabajofinal2.repository;

import com.ayi.trabajofinal2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 * Repositorio JPA encargado de la persistencia y recuperación de datos relacionados con los productos.
 * Este repositorio proporciona métodos para realizar operaciones sobre los datos de productos en la base de datos.
 */
@Repository
public interface IProductoRepository extends JpaRepository<Producto,Integer> {
    @Modifying
    @Query(value = "UPDATE productos SET codigo_ean = :codigoEan, nombre_producto = :nombreProducto, descripcion_producto = :descripcionProducto, tipo = :tipo, marca = :marca, precio = :precio, stock =:stock WHERE id_producto = :idProducto", nativeQuery = true)
    void updateProducto(
            @Param("codigoEan") String codigoEan,
            @Param("nombreProducto") String nombreProducto,
            @Param("descripcionProducto") String descripcionProducto,
            @Param("tipo") String tipo,
            @Param("marca") String marca,
            @Param("precio") float precio,
            @Param("stock") int stock,
            @Param("idProducto") int idProducto
    );
}
