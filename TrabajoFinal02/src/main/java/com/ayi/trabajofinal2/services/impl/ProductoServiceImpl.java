package com.ayi.trabajofinal2.services.impl;

import com.ayi.trabajofinal2.model.Producto;
import com.ayi.trabajofinal2.repository.IProductoRepository;
import com.ayi.trabajofinal2.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    IProductoRepository productoRepository;
    @Override
    public List<Producto> getListaProductos() {
        return productoRepository.findAll();
    }
}
