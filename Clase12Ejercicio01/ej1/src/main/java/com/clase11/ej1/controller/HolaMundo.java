package com.clase11.ej1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
    @GetMapping("/")
    public String holaMundo(){
        return "Hola mundo seguro!";
    }

}
