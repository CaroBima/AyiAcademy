package com.clase09.ejercicio01.controller;

import com.clase09.ejercicio01.entities.Usuario;
import com.clase09.ejercicio01.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

//@RestController
@Controller
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @Value("${titulo}")
    private String titulo;

    @GetMapping("/usuarios")
    public String getListaUsuarios(Model model){
        List<Usuario> listaUsuarios = usuarioService.traerTodosLosUsuarios();

        model.addAttribute("titulo", titulo);

        model.addAttribute("listaUsuarios", listaUsuarios);

        return "index";
    }

    @GetMapping("/usuariosrest")
    public List<Usuario> getListaUsuarios(){
       return  usuarioService.traerTodosLosUsuarios();

    }
}
