package com.ayi.trabajofinal01.services.impl;

import com.ayi.trabajofinal01.entities.Empleado;
import com.ayi.trabajofinal01.repository.IEmpleadoRepository;
import com.ayi.trabajofinal01.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    IEmpleadoRepository empleadoRepository;
    public List<Empleado> buscarListaEmpleados(){
        return empleadoRepository.findAll();
    }

    public void guardarNuevoEmpleado(Empleado empleado){
        empleadoRepository.save(empleado);
    }

    @Override
    public void editarEmpleado(Empleado empleado) {
        
        empleadoRepository.save(empleado);
    }
}
