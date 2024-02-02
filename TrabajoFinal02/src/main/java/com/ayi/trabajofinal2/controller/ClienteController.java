package com.ayi.trabajofinal2.controller;

import com.ayi.trabajofinal2.model.Cliente;
import com.ayi.trabajofinal2.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    IClienteService clienteService;

    @GetMapping("/listarclientes")
    public List<Cliente> getListaClientes(){
        return clienteService.getListaClientes();
    }
}
