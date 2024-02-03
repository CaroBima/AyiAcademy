package com.ayi.trabajofinal2.services;


import com.ayi.trabajofinal2.model.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> getListaClientes();

    void guardar(Cliente cliente);
    void borrar(String idCliente);
    void editar(Cliente cliente);
}
