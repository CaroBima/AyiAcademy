package com.clase09.ejercicio02.repository;

import com.clase09.ejercicio02.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISucursalRepository extends JpaRepository<Sucursal, Integer> {
}
