package com.ayi.trabajofinal2.services;


import com.ayi.trabajofinal2.model.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> getListaClientes();

    boolean guardar(Cliente cliente);
    boolean borrar(String idCliente);
    boolean editar(Cliente cliente);
}
