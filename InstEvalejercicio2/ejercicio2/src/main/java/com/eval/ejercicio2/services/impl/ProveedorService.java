package com.eval.ejercicio2.services.impl;

import com.eval.ejercicio2.entities.Proveedor;
import com.eval.ejercicio2.repository.IProveedorRepository;
import com.eval.ejercicio2.services.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    IProveedorRepository proveedorRepository;
    @Override
    public List<Proveedor> obtenerListado() {
        return proveedorRepository.findAll();
    }

    @Override
    public void borrarProveedorPorId(String idProveedor) {
        int idProv = Integer.parseInt(idProveedor);
        proveedorRepository.deleteById(idProv);

    }

    @Override
    public void editarProveedor(Proveedor proveedorEditado) {

    }

    @Override
    public void guardarProveedor(Proveedor nuevoProveedor) {
        proveedorRepository.save(nuevoProveedor);

    }

    @Override
    public Proveedor buscarPorId(String idProveedor) {
        int idProv = Integer.parseInt(idProveedor);
        return proveedorRepository.findById(idProv).orElse(null);
    }


}
