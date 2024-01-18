package com.clase06.ejercicio02.controller;

import com.clase06.ejercicio02.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ClienteController {

    @GetMapping("/")
    public HashMap<Integer, Cliente> getClientes(){
        HashMap<Integer, Cliente> listaClientes = new HashMap<Integer, Cliente>();
        Cliente cliente = new Cliente();

        cliente.setNroCliente(1);
        cliente.setNombre("Pablo");
        cliente.setApellido("Cáceres");
        cliente.setTelefono("3514568774");

        listaClientes.put(cliente.getNroCliente(), cliente);

        cliente = new Cliente();

        cliente.setNroCliente(2);
        cliente.setNombre("Josefina");
        cliente.setApellido("Perez");
        cliente.setTelefono("3514588272");

        listaClientes.put(cliente.getNroCliente(), cliente);

        return listaClientes;

    }
}
