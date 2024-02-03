package com.ayi.trabajofinal2.services.impl;

import com.ayi.trabajofinal2.dto.ProductoDto;
import com.ayi.trabajofinal2.model.Producto;
import com.ayi.trabajofinal2.repository.IProductoRepository;
import com.ayi.trabajofinal2.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void editar(Producto producto) {
        productoRepository.updateProducto(producto.getCodigoEan(), producto.getNombreProducto(), producto.getDescripcionProducto(), producto.getTipo(), producto.getMarca(), producto.getPrecio(), producto.getStock(), producto.getIdProducto());
    }

    @Override
    public void borrar(String idProducto) {
        int id = Integer.parseInt(idProducto);
        productoRepository.deleteById(id);

    }
}
