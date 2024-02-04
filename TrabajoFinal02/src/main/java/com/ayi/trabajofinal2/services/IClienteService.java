package com.ayi.trabajofinal2.services;


import com.ayi.trabajofinal2.model.Cliente;

import java.util.List;

/**
 * Interfaz que define los métodos para gestionar operaciones relacionadas con los Clientes.
 * Esta interfaz proporciona operaciones para consultar el listado de clientes, guardar un nuevo cliente, eliminarlo
 * y editar su información.
 */
public interface IClienteService {
    List<Cliente> getListaClientes();

    boolean guardar(Cliente cliente);
    boolean borrar(String idCliente);
    boolean editar(Cliente cliente);
}
