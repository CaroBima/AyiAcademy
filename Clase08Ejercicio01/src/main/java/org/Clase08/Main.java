package org.Clase08;

import org.Clase08.controller.PersonaController;
import org.Clase08.model.Persona;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona persona = new Persona();
        //leer personas, crear, actualizar y eliminmar por consola

        System.out.print("Nombre: ");
        String nombre =  scanner.nextLine();
        System.out.println("Apellido: ");
        String apellido =  scanner.nextLine();

        persona.setNombre(nombre);
        persona.setNombre(apellido);

        PersonaController personaController = new PersonaController();

        personaController.guardarPersona(persona);

    }
}