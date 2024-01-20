package com.eval.ejercicio2.controller;

import com.eval.ejercicio2.entities.Proveedor;
import com.eval.ejercicio2.services.IProveedorService;
import com.eval.ejercicio2.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProveedorController {
    @Autowired
    IProveedorService proveedorService;

    @GetMapping("/listadoprov")
    public String obtenerListadoProv(Model model){
        List<Proveedor> listaProveedores = proveedorService.obtenerListado();

        model.addAttribute("listaProveedores", listaProveedores);
        return "listadoprov";
    }

    @GetMapping("/nuevoproveedor")
    public String agregarProveedor(Model model){
        model.addAttribute("proveedor", new Proveedor());

        return "nuevoproveedor";
    }

    @PostMapping("/guardar")
    public String guardarProducto(Proveedor proveedor){
        proveedorService.guardarProveedor(proveedor);

        return "redirect:/listadoprov";
    }

    @GetMapping("/borrarprov/{idProveedor}")
    public String borrarProveedor(@PathVariable String idProveedor){
        proveedorService.borrarProveedorPorId(idProveedor);
        return "redirect:/listadoprov";
    }

    @GetMapping("/actualizarprov/{idProveedor}")
    public String actualizarProveedor(@PathVariable String idProveedor, Model model){
        Proveedor proveedor = proveedorService.buscarPorId(idProveedor);

        model.addAttribute("proveedor", proveedor);

        return "editarproveedor";
    }
}
