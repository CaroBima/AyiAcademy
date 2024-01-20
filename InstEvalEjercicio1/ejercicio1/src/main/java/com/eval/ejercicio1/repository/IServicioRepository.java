package com.eval.ejercicio1.repository;

import com.eval.ejercicio1.entities.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicioRepository extends JpaRepository<Servicio, Integer> {
}
