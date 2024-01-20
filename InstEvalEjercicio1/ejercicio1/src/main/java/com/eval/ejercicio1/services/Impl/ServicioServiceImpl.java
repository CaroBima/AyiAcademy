package com.eval.ejercicio1.services.Impl;

import com.eval.ejercicio1.entities.Servicio;
import com.eval.ejercicio1.repository.IServicioRepository;
import com.eval.ejercicio1.services.IServicioService;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements IServicioService {
    @Autowired
    IServicioRepository servicioRepository;
    @Override
    public List<Servicio> obtenerServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public void borrarServicioPorId(String idServicio) {
        int idServ = Integer.parseInt(idServicio);
        System.out.println(idServ);
        servicioRepository.deleteById(idServ);
    }
}
