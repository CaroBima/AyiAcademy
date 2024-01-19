package com.clase09.ejercicio02.services;

import com.clase09.ejercicio02.entities.Sucursal;
import com.clase09.ejercicio02.repository.ISucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements ISucursalService{
    @Autowired
    ISucursalRepository sucursalRepository;
    @Override
    public List<Sucursal> listarSucursales() {
        return sucursalRepository.findAll();
    }
}
