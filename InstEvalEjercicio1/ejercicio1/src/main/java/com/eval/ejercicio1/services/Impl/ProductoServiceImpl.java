package com.eval.ejercicio1.services.Impl;

import com.eval.ejercicio1.entities.Producto;
import com.eval.ejercicio1.repository.IProductoRepository;
import com.eval.ejercicio1.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    IProductoRepository productoRepository;

    public List<Producto> obtenerProductos(){
        return productoRepository.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }


}
