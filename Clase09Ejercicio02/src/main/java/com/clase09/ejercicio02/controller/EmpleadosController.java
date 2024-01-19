package com.clase09.ejercicio02.controller;

import com.clase09.ejercicio02.entities.Empleado;
import com.clase09.ejercicio02.entities.Sucursal;
import com.clase09.ejercicio02.services.IEmpleadoService;
import com.clase09.ejercicio02.services.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmpleadosController {

    @Value("${titulo}")
    private String titulo;

    @Autowired
    IEmpleadoService empleadoService;

    @Autowired
    ISucursalService sucursalService;

    @GetMapping("/")
    public String getListas(Model model){
        List<Empleado> listaEmpleados = empleadoService.listarEmpleados();
        List<Sucursal> listaSucursales = sucursalService.listarSucursales();

        model.addAttribute("titulo", titulo);
        model.addAttribute("listaEmpleados", listaEmpleados);
        model.addAttribute("listaSucursales", listaSucursales);

        return "index";

    }
}
