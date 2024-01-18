package com.clase06.ejercicio03.model.controller;

import com.clase06.ejercicio03.model.Empleado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class EmpleadoController {

    @GetMapping("/empleados")
    public LinkedList<Empleado> getListaEmpleados(){
        LinkedList<Empleado> listaEmpleados = new LinkedList<>();
        Empleado empleado = new Empleado();

        empleado.setLegajo(1);
        empleado.setNombre("Juan");
        empleado.setApellido("Marquez");
        empleado.setAntiguedad(10);

        listaEmpleados.add(empleado);

        empleado = new Empleado();
        empleado.setLegajo(2);
        empleado.setNombre("Mariela");
        empleado.setApellido("Marquez");
        empleado.setAntiguedad(8);
        listaEmpleados.add(empleado);

        empleado = new Empleado();
        empleado.setLegajo(2);
        empleado.setNombre("Juana");
        empleado.setApellido("Molina");
        empleado.setAntiguedad(1);
        listaEmpleados.add(empleado);

        return listaEmpleados;

    }
}
