package com.clase06.Ejercicio01;

/*
 * El proyecto debe ser de tipo REST
 * Deberá enviar el título (“Curso, Java Spring y React”) desde el controlador.
 * Enviarlo desde el archivo de configuración application.yml
 * Correr el proyecto, verificar en el navegador y en el Postman
 * Modificar el proyecto para que reciba por parámetro un nombre o varios nombres, luego que
 * los muestre en el navegador
 * Probar esto último también en Postman, enviar los datos también por Postman
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ejercicio01Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio01Application.class, args);
	}

}
