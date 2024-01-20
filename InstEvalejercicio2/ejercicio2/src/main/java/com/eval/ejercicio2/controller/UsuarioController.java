package com.eval.ejercicio2.controller;

import com.eval.ejercicio2.entities.Usuario;
import com.eval.ejercicio2.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/")
    public String mostrarLogueo(Model model){
        model.addAttribute("usuario", new Usuario());

        return "index";
    }

    @PostMapping("/login")
    public String mostrarLogueo(Usuario usuario, Model model) {
        //model.addAttribute("usuarioDto", new UsuarioDto());

        boolean existeUsuario = usuarioService.validarLogueo(usuario);

        if (!existeUsuario) {
            model.addAttribute("usuario", new Usuario());
            return "redirect:/";
        }else{
            return "redirect:/listadoprov";}


    }

}
