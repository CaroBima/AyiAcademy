package com.clase07.Ejercicio02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class CopasMundialesController {
    @GetMapping("/")
    public String getCopas(Model model){
        model.addAttribute("titulo", "Países con copas mundiales de la FIFA");
        HashMap<String, Integer> listaPaises = new HashMap<String, Integer>();
        listaPaises.put("España", 1);
        listaPaises.put("Inglaterra", 1);
        listaPaises.put("Francia", 2);
        listaPaises.put("Uruguay", 2);
        listaPaises.put("Argentina", 3);
        listaPaises.put("Italia", 4);
        listaPaises.put("Alemania", 4);
        listaPaises.put("Brasil", 5);

        model.addAttribute("listaPaises", listaPaises);



        return "index";
    }

}
