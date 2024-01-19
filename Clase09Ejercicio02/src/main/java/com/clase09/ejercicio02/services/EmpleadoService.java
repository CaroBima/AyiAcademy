package com.clase09.ejercicio02.services;

import com.clase09.ejercicio02.entities.Empleado;
import com.clase09.ejercicio02.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService{
    @Autowired
    IEmpleadoRepository empleadoRepository;
    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }
}
