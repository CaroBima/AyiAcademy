package com.ayi.trabajofinal2.controller;

import com.ayi.trabajofinal2.dto.ProductoDto;
import com.ayi.trabajofinal2.model.Producto;
import com.ayi.trabajofinal2.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    IProductoService productoService;

    @GetMapping("/listado")
    public ResponseEntity<List<Producto>> getListaProductos(){
        List<Producto> listaProductos = productoService.getListaProductos();
        return ResponseEntity.ok(listaProductos);
    }

    @PostMapping("/guardar")
    public ResponseEntity guardarProducto(@RequestBody ProductoDto productoDto){
        productoService.guardar(productoDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity editarProducto(@RequestBody Producto producto){
        productoService.editar(producto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{idProducto}")
    public ResponseEntity borrarProducto(@PathVariable String idProducto){
        productoService.borrar(idProducto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
