package com.clase09.ejercicio3.services;

import com.clase09.ejercicio3.entities.Auto;
import com.clase09.ejercicio3.repository.IAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService implements IAutoService{

    @Autowired
    IAutoRepository autoRepository;
    public List<Auto> traerAutos(){
        return autoRepository.findAll();
    }
}
