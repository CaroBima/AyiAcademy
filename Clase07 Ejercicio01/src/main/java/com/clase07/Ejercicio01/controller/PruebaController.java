package com.clase07.Ejercicio01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PruebaController {

    @GetMapping("/")
    public String getTitulo(Model model){
        model.addAttribute("titulo", "Modificado desde la controladora");

        return "index";
    }
}
