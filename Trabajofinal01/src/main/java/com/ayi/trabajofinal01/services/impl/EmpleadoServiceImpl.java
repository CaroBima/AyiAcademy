package com.ayi.trabajofinal01.services.impl;

import com.ayi.trabajofinal01.entities.Empleado;
import com.ayi.trabajofinal01.repository.IEmpleadoRepository;
import com.ayi.trabajofinal01.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    IEmpleadoRepository empleadoRepository;
    @Override
    public List<Empleado> buscarListaEmpleados(){
        return empleadoRepository.findAll();
    }

    @Override
    public void guardarNuevoEmpleado(Empleado empleado){
        empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public void editarEmpleado(Empleado empleado) {
        empleadoRepository.updateEmpleado(empleado.getNombreEmpleado(), empleado.getApellidoEmpleado(), empleado.getCargo(), empleado.getSucursal(), empleado.getAntiguedadAnios(), empleado.getLegajo());

    }

    @Override
    public void borrarEmpleado(String idEmpleado){
        int id = Integer.parseInt(idEmpleado);
        empleadoRepository.deleteById(id);


    }
}
