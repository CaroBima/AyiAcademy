package com.clase09.ejercicio02.repository;

import com.clase09.ejercicio02.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
