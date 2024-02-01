package com.ayi.trabajofinal01.repository;

import com.ayi.trabajofinal01.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
    @Modifying
    @Query(value = "UPDATE empleados SET nombre_empleado = :nombreEmpleado, apellido_empleado = :apellidoEmpleado, cargo = :cargo, sucursal = :sucursal, antiguedad_anios = :antiguedadAnios WHERE legajo = :legajo", nativeQuery = true)
    void updateEmpleado(
            @Param("nombreEmpleado") String nombreEmpleado,
            @Param("apellidoEmpleado") String apellidoEmpleado,
            @Param("cargo") String cargo,
            @Param("sucursal") String sucursal,
            @Param("antiguedadAnios") int antiguedadAnios,
            @Param("legajo") int legajo
    );
}

