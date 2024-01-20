package com.eval.ejercicio1.controllers;

import com.eval.ejercicio1.Dto.UsuarioDto;
import com.eval.ejercicio1.entities.Producto;
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


    @GetMapping("/")
    public String mostrarLogueo(Model model){
        model.addAttribute("usuario", new UsuarioDto());


        return "index";
    }


    @PostMapping("/login")
    public String mostrarLogueo(UsuarioDto usuarioDto, Model model) {
        //model.addAttribute("usuarioDto", new UsuarioDto());

        boolean existeUsuario = usuarioService.validarLogueo(usuarioDto);

        if (!existeUsuario) {
            model.addAttribute("usuarioDto", new UsuarioDto());
            return "redirect:/";
        }else{
            return "redirect:/listados";}


    }

}
