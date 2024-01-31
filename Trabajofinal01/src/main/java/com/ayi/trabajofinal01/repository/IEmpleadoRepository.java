package com.ayi.trabajofinal01.repository;

import com.ayi.trabajofinal01.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
