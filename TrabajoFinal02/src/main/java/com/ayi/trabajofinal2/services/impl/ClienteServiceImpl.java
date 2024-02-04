package com.ayi.trabajofinal2.services.impl;

import com.ayi.trabajofinal2.model.Cliente;
import com.ayi.trabajofinal2.repository.IClienteRepository;
import com.ayi.trabajofinal2.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementación de la interfaz {@link IClienteService}.
 * ClienteServiceImpl es un servicio que proporciona métodos para obtener información sobre los clientes y
 * gestionar la información sobre los mismos.
 * @see IClienteService
 * @see Cliente
 */
@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    IClienteRepository clienteRepository;

    /**
     * Permite realizar la busqueda de todos los usuarios que se encuentran almacenados en la base de datos
     * @return Lista de clientes
     */
    @Override
    public List<Cliente> getListaClientes() {
        return clienteRepository.findAll();
    }

    /**
     * Gestiona el guardado de un nuevo cliente en la base de datos. Recibe un cliente por parámetro, valida que los
     * datos sean correctos y si lo son, realiza el guardado.
     * @param cliente
     * @return boolean - Devuelve true en caso de haberse realizado el guardado y false en caso de que no se haya realizado
     * porque los valores recibidos por parámetro no son correctos
     */
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

    /**
     * Permite realizar el borrado de un cliente, recibiendo el Id del cliente a borrar por parámetro
     * @param idCliente
     * @return boolean - Retorna true si fue borrado, en caso de no poder realizar el guardado devuelve false
     */
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

    /**
     * Permite la edición de un cliente. Recibe los datos del cliente a editar por parámetro, valida que dichos datos sean
     * correctos y en caso de serlo, se realiza el guardado de los datos
     * @param cliente
     * @return boolean - Devuelve true en caso de que se haya realizado el guardado y false en caso de que alguno de los
     * valores recibiodos no sea correcto.
     */
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
