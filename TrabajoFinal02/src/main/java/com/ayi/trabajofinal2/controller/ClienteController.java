package com.ayi.trabajofinal2.controller;

import com.ayi.trabajofinal2.model.Cliente;
import com.ayi.trabajofinal2.services.IClienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    IClienteService clienteService;

    @GetMapping("/listado")
    public ResponseEntity<List<Cliente>> getListaClientes(){
        List<Cliente> listadoClientes = clienteService.getListaClientes();
        return ResponseEntity.ok(listadoClientes);
    }

    @PostMapping("/nuevo")
    public ResponseEntity crearNuevoCliente(@RequestBody Cliente nuevoCliente){
        clienteService.guardar(nuevoCliente);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity borrarCliente(@RequestParam String idCliente){
        clienteService.borrar(idCliente);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/editar")
    public ResponseEntity editarCliente(@RequestBody Cliente cliente){
        clienteService.editar(cliente);
        return new ResponseEntity(HttpStatus.OK);
    }
}
