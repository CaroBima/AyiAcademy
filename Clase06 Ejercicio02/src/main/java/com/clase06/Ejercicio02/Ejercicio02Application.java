package com.clase06.Ejercicio02;

/*
El proyecto debe ser de tipo REST
Probar todas las formas de modificar el puerto
Crear una clase Clientes (NroCliente, nombre, apellido, y telefono),
con la librería importada Lombok utilizar las anotaciones
Enviar en un HashMap los datos de los Clientes al navegador
Del punto anterior, ejecutar Postman y verificar la lista que devuelve

 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ejercicio02Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio02Application.class, args);
	}

}
