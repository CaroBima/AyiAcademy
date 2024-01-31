package com.ayi.trabajofinal01.repository;

import com.ayi.trabajofinal01.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
