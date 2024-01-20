package com.eval.ejercicio1.controllers;


import com.eval.ejercicio1.entities.Servicio;
import com.eval.ejercicio1.services.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServicioController {

    @Autowired
    IServicioService servicioService;

    @GetMapping("/nuevoservicio")
    public String agregarServicio(Model model){
        model.addAttribute("servicio", new Servicio());
        return "nuevoservicio";
    }


    @PostMapping("/guardarservicio")
    public String guardarServicio(Servicio servicio){
        servicioService.guardarServicio(servicio);
        return "redirect:/listados";
    }

    @GetMapping("/borrarservicio/{idServicio}")
    public String borrarServicio(@PathVariable String idServicio){
        servicioService.borrarServicioPorId(idServicio);
        return "redirect:/listados";
    }
}
