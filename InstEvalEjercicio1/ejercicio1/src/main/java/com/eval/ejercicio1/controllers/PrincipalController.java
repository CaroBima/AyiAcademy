package com.eval.ejercicio1.controllers;

import com.eval.ejercicio1.entities.Producto;
import com.eval.ejercicio1.entities.Servicio;
import com.eval.ejercicio1.repository.IServicioRepository;
import com.eval.ejercicio1.services.IProductoService;
import com.eval.ejercicio1.services.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PrincipalController {

    @Autowired
    IProductoService productoService;

    @Autowired
    IServicioService servicioService;

    @Value("${tituloProd}")
    String tituloProd;

    @Value("${tituloServ}")
    String tituloServ;

    @GetMapping("/listados")
    public String cargarInformacion (Model model){
        List<Producto> listaProductos = productoService.obtenerProductos();
        List<Servicio> listaServicios = servicioService.obtenerServicios();

        model.addAttribute("tituloProd", tituloProd);
        model.addAttribute("tituloServ", tituloServ);
        model.addAttribute("listaProductos", listaProductos);
        model.addAttribute("listaServicios", listaServicios);

        return "listados";
    }

}
