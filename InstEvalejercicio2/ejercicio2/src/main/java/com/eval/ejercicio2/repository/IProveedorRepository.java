package com.eval.ejercicio2.repository;

import com.eval.ejercicio2.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {
}
