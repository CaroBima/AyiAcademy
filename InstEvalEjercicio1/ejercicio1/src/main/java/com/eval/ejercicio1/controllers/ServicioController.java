package com.eval.ejercicio1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicioController {
    @GetMapping("/nuevoservicio")
    public String agregarServicio(Model model){
        return "nuevoservicio";
    }
}
