package com.ayi.trabajofinal2.services.impl;

import com.ayi.trabajofinal2.model.Usuario;
import com.ayi.trabajofinal2.repository.IUsuarioRepository;
import com.ayi.trabajofinal2.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;
    public boolean validarLogueo(Usuario usuario){
        Usuario existeUsuario = usuarioRepository.findUsuario(usuario.getNombreUsuario(), usuario.getPasswordUsuario());
        if(existeUsuario != null){
            return true;
        }else{
            return false;
        }
    }
}
