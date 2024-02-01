package com.ayi.trabajofinal01.services;

import com.ayi.trabajofinal01.entities.Empleado;

import java.util.List;

public interface IEmpleadoService {
    List<Empleado> buscarListaEmpleados();
    void guardarNuevoEmpleado(Empleado empleado);
    void editarEmpleado(Empleado empleado);
    void borrarEmpleado(String idEmpleado);
}
