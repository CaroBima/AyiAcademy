package com.ayi.trabajofinal2.services.impl;

import com.ayi.trabajofinal2.dto.ProductoDto;
import com.ayi.trabajofinal2.model.Producto;
import com.ayi.trabajofinal2.repository.IProductoRepository;
import com.ayi.trabajofinal2.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementación de la interfaz {@link IProductoService}.
 * ClienteServiceImpl es un servicio que proporciona métodos para obtener información sobre los clientes y
 * gestionar la información sobre los mismos.
 * @see IProductoService
 * @see Producto
 */
@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    IProductoRepository productoRepository;

    /**
     * Permite obtener un listado completo de los productos que se encuentran almacenados en la base de datos
     * @return listado de productos
     */
    @Override
    public List<Producto> getListaProductos() {
        return productoRepository.findAll();
    }

    /**
     * Realiza el guardado de los datos de un producto en la base de datos
     * @param productoDto
     * @return true en caso de que se hayan guardado, false en caso de que al menos uno de los valores recibidos por
     * parametro no sea correcto.
     */
    @Override
    public boolean guardar(ProductoDto productoDto) {
        Producto producto = new Producto();

        producto.setCodigoEan(productoDto.getCodigoEan());
        producto.setNombreProducto(productoDto.getNombreProducto());
        producto.setDescripcionProducto(productoDto.getDescripcionProducto());
        producto.setTipo(productoDto.getTipo());
        producto.setMarca(productoDto.getMarca());
        producto.setPrecio(productoDto.getPrecio());
        producto.setStock(productoDto.getStock());

        if (producto !=null &&
                producto.getCodigoEan().length()>0 && producto.getCodigoEan().length()<=25 &&
                producto.getNombreProducto().length()>0 && producto.getNombreProducto().length()<=25 &&
                producto.getDescripcionProducto().length()>0 && producto.getDescripcionProducto().length() <=100 &&
                producto.getTipo().length() > 0 && producto.getTipo().length() <= 15 &&
                producto.getMarca().length() > 0 && producto.getMarca().length() <= 20 &&
                producto.getPrecio() >0 && producto.getPrecio() <= 999.99 &&
                producto.getStock() >=0) {
                    productoRepository.save(producto);
            return true;
        } else{
            return false;
        }
    }

    /**
     * Para realizar la edición de un producto que ya se encuentra previamente guardado en la base de datos
     * @param producto
     * @return true en caso de que los datos puedan ser guardados, false en caso de que al menos uno de los datos
     * recibidos sea incorrecto.
     */
    @Override
    @Transactional
    public boolean editar(Producto producto) {

        if (producto !=null &&
            producto.getCodigoEan().length()>0 && producto.getCodigoEan().length()<=25 &&
            producto.getNombreProducto().length()>0 && producto.getNombreProducto().length()<=25 &&
            producto.getDescripcionProducto().length()>0 && producto.getDescripcionProducto().length() <=100 &&
            producto.getTipo().length() > 0 && producto.getTipo().length() <= 15 &&
            producto.getMarca().length() > 0 && producto.getMarca().length() <= 20 &&
            producto.getPrecio() >0 && producto.getPrecio() <= 999.99 &&
            producto.getStock() >=0) {

            productoRepository.updateProducto(producto.getCodigoEan(), producto.getNombreProducto(), producto.getDescripcionProducto(), producto.getTipo(), producto.getMarca(), producto.getPrecio(), producto.getStock(), producto.getIdProducto());
            return true;
        }else{
            return false;
        }
    }

    /**
     * Permite realizar el borrado de un producto cuyo id se recibe por parámetro.
     * El id es recibido como String, lo convierte en int y posteriormente realiza el borrado
     * @param idProducto
     * @return true en caso de que se pueda realizar el borrado, false en caso de que se produzca alguna excepción.
     */
    @Override
    public boolean borrar(String idProducto) {
        try {
        int id = Integer.parseInt(idProducto);
        productoRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
