package com.ayi.trabajofinal2.repository;

import com.ayi.trabajofinal2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Integer> {
}
