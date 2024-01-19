package com.eval.ejercicio1.controllers;

import com.eval.ejercicio1.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarLogueo(Model model) {

        boolean existeUsuario = usuarioService.validarLogueo(nombreUsuario, contrasenia)

        if () {
            return "login";
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}
