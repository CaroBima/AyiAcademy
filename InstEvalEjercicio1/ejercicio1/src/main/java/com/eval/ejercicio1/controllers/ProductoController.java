package com.eval.ejercicio1.controllers;

import com.eval.ejercicio1.entities.Producto;
import com.eval.ejercicio1.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductoController {

    @Autowired
    IProductoService productoService;
    @GetMapping("/nuevoproducto")
    public String agregarProducto(Model model){
        model.addAttribute("producto", new Producto());

        return "nuevoproducto";
    }

    @PostMapping("/guardar")
    public String guardarProducto(Producto producto){
        productoService.guardarProducto(producto);

        //model.addAttribute("producto", producto);
        return "redirect:/listados";
    }

    @GetMapping("/borrarproducto/{idProducto}")
    public String borrarProducto(@PathVariable String idProducto){
        productoService.borrarProductoPorId(idProducto);
        return "redirect:/listados";
    }
}
