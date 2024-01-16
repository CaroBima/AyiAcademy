package com.clase06.Ejercicio01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * El proyecto debe ser de tipo REST
 * Deberá enviar el título (“Curso, Java Spring y React”) desde el controlador.
 * Enviarlo desde el archivo de configuración application.yml
 * Correr el proyecto, verificar en el navegador y en el Postman
 * Modificar el proyecto para que reciba por parámetro un nombre o varios nombres, luego que
 * los muestre en el navegador
 * Probar esto último también en Postman, enviar los datos también por Postman
 */

//@PropertySource(value = "classpath:application.yml")
@RestController
public class EjercicioController {
    @Value("${cadena}")
    private String cadenaCurso;

    @GetMapping("/controlador")
    public String getTituloControlador(){
        return "Curso, Java Spring y React";
    }

    @GetMapping("/yml")
    public String getTituloYml(){
       return cadenaCurso;

    }

    @GetMapping("/variables")
    public String getCadena(@RequestParam String nombres){
        return nombres;
    }

}
