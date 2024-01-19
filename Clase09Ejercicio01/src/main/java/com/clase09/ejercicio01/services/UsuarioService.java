package com.clase09.ejercicio01.services;

import com.clase09.ejercicio01.entities.Usuario;
import com.clase09.ejercicio01.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    IUsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> traerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }


}
