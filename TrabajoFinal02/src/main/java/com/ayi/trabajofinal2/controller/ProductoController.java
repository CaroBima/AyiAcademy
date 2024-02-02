package com.ayi.trabajofinal2.controller;

import com.ayi.trabajofinal2.model.Producto;
import com.ayi.trabajofinal2.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    IProductoService productoService;

    @GetMapping("/listarproductos")
    public List<Producto> getListaProductos(){
        return productoService.getListaProductos();
    }
}
