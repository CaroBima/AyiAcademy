package com.eval.ejercicio2.repository;

import com.eval.ejercicio2.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "Select * from usuarios where nombre = :nombreUsuario and password_usuario = :contrasenia", nativeQuery = true )
    Usuario findUsuario(@Param("nombreUsuario") String nombreUsuario, @Param("contrasenia") String contrasenia);
}
