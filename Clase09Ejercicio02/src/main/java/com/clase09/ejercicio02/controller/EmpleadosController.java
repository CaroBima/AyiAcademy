package com.clase09.ejercicio02.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpleadosController {

    @Value("${titulo}")
    private String titulo;

    @GetMapping("/")
    public String getListas(Model model){
        model.addAttribute(titulo);


        return "index";
    }
}
