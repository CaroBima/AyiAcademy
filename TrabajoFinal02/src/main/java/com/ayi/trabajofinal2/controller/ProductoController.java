package com.ayi.trabajofinal2.controller;

import com.ayi.trabajofinal2.model.Producto;
import com.ayi.trabajofinal2.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    IProductoService productoService;

    @GetMapping("/listado")
    public ResponseEntity<List<Producto>> getListaProductos(){
        return ResponseEntity.ok(productoService.getListaProductos());
    }
}
