package com.ayi.trabajofinal2.repository;

import com.ayi.trabajofinal2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "Select * from usuarios where nombre_usuario = :nombreUsuario and password_usuario = :contrasenia", nativeQuery = true )
    Usuario findUsuario(@Param("nombreUsuario") String nombreUsuario, @Param("contrasenia") String contrasenia);

}
