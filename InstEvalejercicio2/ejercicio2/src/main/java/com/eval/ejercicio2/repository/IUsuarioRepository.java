package com.eval.ejercicio2.repository;

import com.eval.ejercicio2.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
