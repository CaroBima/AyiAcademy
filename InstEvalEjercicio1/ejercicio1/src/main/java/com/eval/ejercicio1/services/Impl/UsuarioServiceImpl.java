package com.eval.ejercicio1.services.Impl;

import com.eval.ejercicio1.entities.Usuario;
import com.eval.ejercicio1.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioService usuarioService;
    public boolean validarLogueo(String nombreUsuario, String contrasenia){
        boolean existeUsuario;
        return existeUsuario = usuarioService.validarLogueo(nombreUsuario, contrasenia);
    }
       
}
