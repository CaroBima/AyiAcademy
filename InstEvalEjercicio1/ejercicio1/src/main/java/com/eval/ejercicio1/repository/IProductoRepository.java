package com.eval.ejercicio1.repository;

import com.eval.ejercicio1.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductoRepository {
    @Query(value = "Select * from usuario where nombreUsuario = :nombreUsuario and password = :contrasenia", nativeQuery = true )
    Usuario findUsuario(@Param("nombreUsuario") String nombreUsuario, @Param("contrasenia") String contrasenia);
}

