package com.ayi.trabajofinal2.repository;

import com.ayi.trabajofinal2.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
    @Modifying
    @Query(value = "UPDATE clientes SET nombre = :nombre, apellido = :apellido, fecha_ingreso = :fechaIngreso, domicilio = :domicilio, telefono = :telefono WHERE id_cliente = :idCliente", nativeQuery = true)
    void updateCliente(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("fechaIngreso") String fechaIngreso,
            @Param("domicilio") String domicilio,
            @Param("telefono") String telefono,
            @Param("idCliente") int idCliente
    );
}
