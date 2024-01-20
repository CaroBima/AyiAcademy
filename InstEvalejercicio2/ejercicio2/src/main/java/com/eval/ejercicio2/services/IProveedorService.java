package com.eval.ejercicio2.services;

import com.eval.ejercicio2.entities.Proveedor;

import java.util.List;

public interface IProveedorService {
    List<Proveedor> obtenerListado();
    void borrarProveedorPorId(String idProveedor);
    void editarProveedor(Proveedor proveedorEditado);
    void guardarProveedor(Proveedor nuevoProveedor);
    Proveedor buscarPorId(String idProv);


}
