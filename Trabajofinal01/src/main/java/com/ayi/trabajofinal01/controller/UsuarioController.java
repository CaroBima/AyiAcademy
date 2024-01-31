package com.ayi.trabajofinal01.controller;

import com.ayi.trabajofinal01.entities.Usuario;
import com.ayi.trabajofinal01.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioController{

    @Autowired
    IUsuarioService usuarioService;

    /**
     * Endpoint que permite validar el logueo de usuarios. Devuelve un responseEntity indicando que esta ok y el usuario en caso de que los datos
     * ingresados sean correctos, en caso de que no coincidan con los que están en la base de datos el response entity devuelto es el de conflict
     * @param usuario
     * @return ResponseEntity<Usuario>
     */
    @GetMapping("/login")
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
