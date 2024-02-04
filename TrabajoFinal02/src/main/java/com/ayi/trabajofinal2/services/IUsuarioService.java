package com.ayi.trabajofinal2.services;

import com.ayi.trabajofinal2.model.Usuario;

/**
 * Interfaz que proporciona metodos para validar el logueo del usuario
 */
public interface IUsuarioService {
    boolean validarLogueo(Usuario usuario);
}
