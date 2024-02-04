package com.ayi.trabajofinal2.controller;

import com.ayi.trabajofinal2.model.Cliente;
import com.ayi.trabajofinal2.model.Usuario;
import com.ayi.trabajofinal2.services.IClienteService;
import com.ayi.trabajofinal2.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST que maneja las operaciones relacionadas a los usuarios.
 * @see Usuario
 * @see IUsuarioService
 */
@RestController
public class UsuarioController {
    @Autowired
    IUsuarioService usuarioService;

    /**
     * Permite realizar el logueo del usuario contrastando con el almacenado en la base de datos
     *
     * @return ResponseEntity indicando logueo ok o conflict en caso de que no coincidan los datos
     */
    @PostMapping("/login")
    public ResponseEntity<Usuario> validarLogueo(@RequestBody Usuario usuario) {

        boolean existeUsuario = usuarioService.validarLogueo(usuario);

        if (existeUsuario) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(usuario);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(usuario);
        }


    }
}
