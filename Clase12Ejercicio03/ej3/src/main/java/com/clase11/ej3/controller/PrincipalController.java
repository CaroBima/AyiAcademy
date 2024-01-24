package com.clase11.ej3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalController {

    @GetMapping("/saludo1")
    public String saludoUno(){
        return "Saludo 1";
    }

    @GetMapping("/saludo2")
    public String saludoDos(){
        return "Saludo 2";
    }
}
