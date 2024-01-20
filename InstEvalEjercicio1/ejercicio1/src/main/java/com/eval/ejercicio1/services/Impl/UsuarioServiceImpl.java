package com.eval.ejercicio1.services.Impl;

import com.eval.ejercicio1.Dto.UsuarioDto;
import com.eval.ejercicio1.entities.Usuario;
import com.eval.ejercicio1.repository.IUsuarioRepository;
import com.eval.ejercicio1.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;
    public boolean validarLogueo(UsuarioDto usuario){
        Usuario existeUsuario = usuarioRepository.findUsuario(usuario.getNombreUsuario(), usuario.getPasswordUsuario());

        if(existeUsuario != null){
            return true;
        }else{
            return false;
        }
    }
       
}
