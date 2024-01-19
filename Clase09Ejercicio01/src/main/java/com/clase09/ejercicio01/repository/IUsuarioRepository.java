package com.clase09.ejercicio01.repository;

import com.clase09.ejercicio01.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
