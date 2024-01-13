package com.ejercicio.clasecuatro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {
    @GetMapping("/")
    public ResponseEntity<String> holaMundo(){
        return ResponseEntity.ok("Hola mundo!");
    }

}
