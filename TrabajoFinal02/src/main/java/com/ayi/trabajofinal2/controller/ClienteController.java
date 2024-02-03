package com.ayi.trabajofinal2.controller;

import com.ayi.trabajofinal2.model.Cliente;
import com.ayi.trabajofinal2.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que maneja las operaciones relacionadas con los clientes.
 * Proporciona endpoints para obtener información de los clientes de la base de datos. Permite también insertar nuevos clientes,
 * modificar sus datos y eliminar clientes.
 *
 * @see Cliente
 * @see IClienteService
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    IClienteService clienteService;

    /**
     * Obtiene el listado completo de clientes que se encuentran guardados
     *
     * @return ResponseEntity con el listado de clientes recuperado
     */
    @GetMapping("/listado")
    public ResponseEntity<List<Cliente>> getListaClientes(){
        List<Cliente> listadoClientes = clienteService.getListaClientes();
        return ResponseEntity.ok(listadoClientes);
    }

    /**
     * Permite realizar el guardado de un nuevo cliente.
     * @Param Cliente nuevoCliente - recibe como parámetro el cliente que será persistido
     * @return ResponseEntity confirmando la creación, en caso de haber algun error en los datos recibidos
     * devuelve un bad request
     */
    @PostMapping("/nuevo")
    public ResponseEntity crearNuevoCliente(@RequestBody Cliente nuevoCliente){
        boolean estaGuardado = clienteService.guardar(nuevoCliente);

        return estaGuardado ? new ResponseEntity(HttpStatus.CREATED) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    /**
     * Realiza el borrado de un cliente cuyo id se recibe por parámentro
     * @Param String idCliente
     * @return ResponseEntity No Content en el caso de que el borrado se haya realizado. En el caso de que no se haya
     * podido realizar, devuelve un Bad request
     */
    @DeleteMapping("/borrar/{idCliente}")
    public ResponseEntity borrarCliente(@PathVariable String idCliente){
        boolean sePudoBorrar = clienteService.borrar(idCliente);

        return sePudoBorrar ? new ResponseEntity(HttpStatus.NO_CONTENT) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    /**
     * Permite editar los datos de un usuario que se encuentra almacenado en la base de datos
     * @Param String idCliente
     * @return ResponseEntity Ok en el caso de que se haya podido editar, en caso de que no, devuelve Bad Request
     */
    @PutMapping("/editar")
    public ResponseEntity editarCliente(@RequestBody Cliente cliente){
        boolean sePudoEditar = clienteService.editar(cliente);
        return sePudoEditar ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
