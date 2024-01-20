package com.eval.ejercicio2.services.impl;

import com.eval.ejercicio2.entities.Usuario;
import com.eval.ejercicio2.repository.IUsuarioRepository;
import com.eval.ejercicio2.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;
    public boolean validarLogueo(Usuario usuario){
        Usuario existeUsuario = usuarioRepository.findUsuario(usuario.getNombre(), usuario.getPasswordUsuario());

        if(existeUsuario != null){
            return true;
        }else{
            return false;
        }
    }
}
