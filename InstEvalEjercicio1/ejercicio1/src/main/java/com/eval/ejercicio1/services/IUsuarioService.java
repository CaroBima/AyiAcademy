package com.eval.ejercicio1.services;

import com.eval.ejercicio1.entities.Usuario;

public interface IUsuarioService {
    public boolean validarLogueo(String nombreUsuario, String contrasenia);
}
