package com.clase09.ejercicio3.repository;

import com.clase09.ejercicio3.entities.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutoRepository extends JpaRepository<Auto, Integer> {
}
