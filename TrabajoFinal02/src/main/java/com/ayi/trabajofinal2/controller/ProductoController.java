package com.ayi.trabajofinal2.controller;

import com.ayi.trabajofinal2.dto.ProductoDto;
import com.ayi.trabajofinal2.model.Cliente;
import com.ayi.trabajofinal2.model.Producto;
import com.ayi.trabajofinal2.services.IClienteService;
import com.ayi.trabajofinal2.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que maneja las operaciones relacionadas con los productos
 * Proporciona endpoints para obtener información de los productos de la base de datos. Permite también insertar nuevos productos,
 * eliminarlos y modificar los datos de cada producto almacenado.
 *
 * @see Producto
 * @see IProductoService
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    IProductoService productoService;


    /**
     * Obtiene el listado completo de productos que se encuentran guardados en la base de datos
     *
     * @return ResponseEntity con el listado de productos recuperado
     */
    @GetMapping("/listado")
    public ResponseEntity<List<Producto>> getListaProductos(){
        List<Producto> listaProductos = productoService.getListaProductos();
        return ResponseEntity.ok(listaProductos);
    }


    /**
     * Permite realizar el guardado de un nuevo producto.
     * @Param ProductoDto - recibe como parámetro un Dto de prodcuto con los datos que serán persistidos
     * @return ResponseEntity confirmando la creación, en caso de haber algun error en los datos recibidos
     * devuelve un bad request
     */
    @PostMapping("/guardar")
    public ResponseEntity guardarProducto(@RequestBody ProductoDto productoDto){
        boolean estaGuardado = productoService.guardar(productoDto);
        return estaGuardado ? new ResponseEntity(HttpStatus.CREATED) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/editar")
    public ResponseEntity editarProducto(@RequestBody Producto producto){
        boolean sePudoEditar = productoService.editar(producto);
        return sePudoEditar ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/borrar/{idProducto}")
    public ResponseEntity borrarProducto(@PathVariable String idProducto){

        boolean sePudoBorrar = productoService.borrar(idProducto);

        return sePudoBorrar ? new ResponseEntity(HttpStatus.NO_CONTENT) : new ResponseEntity(HttpStatus.BAD_REQUEST);

    }
}
