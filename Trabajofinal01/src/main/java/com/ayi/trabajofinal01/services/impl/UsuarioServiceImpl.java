package com.ayi.trabajofinal01.services.impl;

import com.ayi.trabajofinal01.entities.Usuario;
import com.ayi.trabajofinal01.repository.IUsuarioRepository;
import com.ayi.trabajofinal01.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
