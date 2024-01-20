package com.eval.ejercicio1.controllers;

import com.eval.ejercicio1.Dto.UsuarioDto;
import com.eval.ejercicio1.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    IUsuarioService usuarioService;

    @PostMapping("/login")
    public String mostrarLogueo(@RequestParam UsuarioDto usuario, Model model) {

        boolean existeUsuario = usuarioService.validarLogueo(usuario);

        if (!existeUsuario) {
            return "login";
        }

        return "index";
    }

}
