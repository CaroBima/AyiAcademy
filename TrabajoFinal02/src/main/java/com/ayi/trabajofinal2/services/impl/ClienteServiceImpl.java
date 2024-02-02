package com.ayi.trabajofinal2.services.impl;

import com.ayi.trabajofinal2.model.Cliente;
import com.ayi.trabajofinal2.repository.IClienteRepository;
import com.ayi.trabajofinal2.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    IClienteRepository clienteRepository;
    @Override
    public List<Cliente> getListaClientes() {
        return clienteRepository.findAll();
    }
}
