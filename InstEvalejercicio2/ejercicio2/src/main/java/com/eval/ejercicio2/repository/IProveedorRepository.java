package com.eval.ejercicio2.repository;

import com.eval.ejercicio2.entities.Proveedor;
import com.eval.ejercicio2.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {
    @Modifying
    @Query(value = "UPDATE proveedores SET nombre = :nombre, telefono = :telefono, direccion = :direccion, email = :email, sitio_web = :sitioWeb, estado = :estado WHERE id_proveedor = :idProveedor", nativeQuery = true)
    void updateProveedor(
            @Param("nombre") String nombre,
            @Param("telefono") String telefono,
            @Param("direccion") String direccion,
            @Param("email") String email,
            @Param("sitioWeb") String sitioWeb,
            @Param("estado") int estado,
            @Param("idProveedor") int idProveedor
    );
}
