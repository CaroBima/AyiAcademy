package com.ayi.trabajofinal2.repository;

import com.ayi.trabajofinal2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA encargado de la persistencia y recuperación de datos relacionados con los Usuarios.
 * Permite comparar el usuario y contraseña recibidos con los que se encuentran almacenados en la base de datos
 * para validar el logueo
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "Select * from usuarios where nombre_usuario = :nombreUsuario and password_usuario = :contrasenia", nativeQuery = true )
    Usuario findUsuario(@Param("nombreUsuario") String nombreUsuario, @Param("contrasenia") String contrasenia);

}
