package com.clase09.ejercicio01.controller;

import com.clase09.ejercicio01.entities.Usuario;
import com.clase09.ejercicio01.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String getListaUsuarios(Model model){
        List<Usuario> listaUsuarios = usuarioService.traerTodosLosUsuarios();

        model.addAttribute("titulo", "Listado de Usuarios");

        model.addAttribute("listaUsuarios", listaUsuarios);

        return "index";
    }
}
