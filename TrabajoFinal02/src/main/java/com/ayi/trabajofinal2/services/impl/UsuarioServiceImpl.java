package com.ayi.trabajofinal2.services.impl;

import com.ayi.trabajofinal2.model.Usuario;
import com.ayi.trabajofinal2.repository.IUsuarioRepository;
import com.ayi.trabajofinal2.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementación de la interfaz {@link IUsuarioService}.
 * ClienteServiceImpl es un servicio que proporciona métodos para obtener información sobre los clientes y
 * gestionar la información sobre los mismos.
 * @see IUsuarioService
 * @see Usuario
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;

    /**
     * Valída que los datos ingresados coincidan con los almacenados en la base de datos, comparando usuario y contraseña
     * @param usuario
     * @return true en caso de que estén correctos, false en caso de que no coincidan
     */
    public boolean validarLogueo(Usuario usuario){
        Usuario existeUsuario = usuarioRepository.findUsuario(usuario.getNombreUsuario(), usuario.getPasswordUsuario());
        if(existeUsuario != null){
            return true;
        }else{
            return false;
        }
    }
}
