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

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    IProductoRepository productoRepository;
    @Override
    public List<Producto> getListaProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void guardar(ProductoDto productoDto) {
        Producto producto = new Producto();

        producto.setCodigoEan(productoDto.getCodigoEan());
        producto.setNombreProducto(productoDto.getNombreProducto());
        producto.setDescripcionProducto(productoDto.getDescripcionProducto());
        producto.setTipo(productoDto.getTipo());
        producto.setMarca(productoDto.getMarca());
        producto.setPrecio(productoDto.getPrecio());
        producto.setStock(productoDto.getStock());

        productoRepository.save(producto);
    }

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
