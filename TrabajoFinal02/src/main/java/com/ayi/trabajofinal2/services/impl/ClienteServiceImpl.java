package com.ayi.trabajofinal2.services.impl;

import com.ayi.trabajofinal2.model.Cliente;
import com.ayi.trabajofinal2.repository.IClienteRepository;
import com.ayi.trabajofinal2.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    IClienteRepository clienteRepository;
    @Override
    public List<Cliente> getListaClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public boolean guardar(Cliente cliente) {

        //valido los datos ingresados antes de guardarlos
        if(cliente.getNombre().length()>0 && cliente.getNombre().length()<=25 &&
            cliente.getApellido().length()>0 && cliente.getApellido().length()<=25 &&
            cliente.getFechaIngreso().length()>0 && cliente.getFechaIngreso().length() <=25 &&
            cliente.getDomicilio().length() > 0 && cliente.getDomicilio().length() <=25 &&
            cliente.getTelefono().length()> 0 && cliente.getTelefono().length()<=15){
            clienteRepository.save(cliente);
            return true;
        } else{
            return false;
        }

    }

    public boolean borrar(String idCliente){

        try {
            int id = Integer.parseInt(idCliente);
            clienteRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public boolean editar(Cliente cliente) {
        //valido los datos ingresados antes de guardarlos
        if(cliente.getNombre().length()>0 && cliente.getNombre().length()<=25 &&
                cliente.getApellido().length()>0 && cliente.getApellido().length()<=25 &&
                cliente.getFechaIngreso().length()>0 && cliente.getFechaIngreso().length() <=25 &&
                cliente.getDomicilio().length() > 0 && cliente.getDomicilio().length() <=25 &&
                cliente.getTelefono().length()> 0 && cliente.getTelefono().length()<=15){
                 clienteRepository.updateCliente(cliente.getNombre(), cliente.getApellido(), cliente.getFechaIngreso(), cliente.getDomicilio(), cliente.getTelefono(), cliente.getIdCliente());
            return true;
        } else{
            return false;
        }
    }
}
