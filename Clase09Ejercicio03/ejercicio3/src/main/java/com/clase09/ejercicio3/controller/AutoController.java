package com.clase09.ejercicio3.controller;

import com.clase09.ejercicio3.entities.Auto;
import com.clase09.ejercicio3.services.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AutoController {

    @Autowired
    IAutoService autoService;
    @GetMapping("/")
    public String mostrarListadoAutos(Model model){
        List<Auto> listaAutos = autoService.traerAutos();

        model.addAttribute("listaAutos", listaAutos);

        return "index";
    }

    /**
     * Busca un vehículo por id y lo pasa a modificar.html para que pueda ser modificado
     * @param idAuto
     * @param model
     * @return
     */
    @GetMapping("/editar/{idAuto}")
    public String editarAuto(String idAuto, Model model){
        System.out.println(idAuto);
        //Auto auto = autoService.traerAutoById(idAuto);

        //System.out.println(auto.getIdAuto());
        //model.addAttribute("auto", auto);

        return "modificar";
    }
}
