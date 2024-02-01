package com.ayi.trabajofinal01.controller;

import com.ayi.trabajofinal01.entities.Empleado;
import com.ayi.trabajofinal01.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    
    @Autowired
    IEmpleadoService empleadoService;
    
    @GetMapping("/listaempleados")
    public List<Empleado> getListaEmpleados(){
        List<Empleado> listaEmpleados = empleadoService.buscarListaEmpleados();
        
        return listaEmpleados;
    }

    @PostMapping("/nuevoempleado")
    public void guardarNuevoEmpleado(@RequestBody Empleado empleado){
        empleadoService.guardarNuevoEmpleado(empleado);
    }

    @PutMapping("/editarempleado")
    public void editarEmpleado(@RequestBody Empleado empleado){
        empleadoService.editarEmpleado(empleado);
    }

    @DeleteMapping("/borrarempleado/{idEmpleado}")
    public void borrarEmpleado(@PathVariable String idEmpleado){
        empleadoService.borrarEmpleado(idEmpleado);
    }
}

