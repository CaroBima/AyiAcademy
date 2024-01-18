package com.clase07.ejercicio03.controller;

import com.clase07.ejercicio03.model.Cliente;
import com.clase07.ejercicio03.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class indexController {
    @GetMapping("/")
    public String getInfo(Model model) {
        HashMap<Integer, Cliente> listaClientes = new HashMap<Integer, Cliente>();
        Cliente cliente = new Cliente();

        HashMap<Integer, Producto> listaProductos = new HashMap<Integer, Producto>();
        Producto producto = new Producto();

        //carga de clientes
        cliente.setNroCliente(1);
        cliente.setNombre("Juan Carlos");
        cliente.setApellido("Iglesias");
        cliente.setEmail("jciglesias5000@gmail.com");
        cliente.setTelefono(1142313546);
        cliente.setDomicilio("Avenida Colon 5000");

        listaClientes.put(cliente.getNroCliente(), cliente);

        cliente = new Cliente();

        cliente.setNroCliente(2);
        cliente.setNombre("Mariel Alejandra");
        cliente.setApellido("Perez");
        cliente.setEmail("marielaperez@gmail.com");
        cliente.setTelefono(1145512536);
        cliente.setDomicilio("Avenida 9 de Julio 2555");

        listaClientes.put(cliente.getNroCliente(), cliente);

        cliente = new Cliente();

        cliente.setNroCliente(3);
        cliente.setNombre("Agustina Vanesa");
        cliente.setApellido("Varela");
        cliente.setEmail("avv-2023@gmail.com");
        cliente.setTelefono(1144444456);
        cliente.setDomicilio("Avenida Rivadavia 6654");

        listaClientes.put(cliente.getNroCliente(), cliente);

        cliente = new Cliente();

        cliente.setNroCliente(4);
        cliente.setNombre("Camila");
        cliente.setApellido("Varela");
        cliente.setEmail("cami_varela@gmail.com");
        cliente.setTelefono(1142354899);
        cliente.setDomicilio("Callao 310");

        listaClientes.put(cliente.getNroCliente(), cliente);

        cliente = new Cliente();

        cliente.setNroCliente(5);
        cliente.setNombre("Facundo");
        cliente.setApellido("Diaz");
        cliente.setEmail("fd-freddy@gmail.com");
        cliente.setTelefono(1154545488);
        cliente.setDomicilio("Avenida Córdoba 251");

        listaClientes.put(cliente.getNroCliente(), cliente);

        //carga de productos
        producto.setIdProducto(12133);
        producto.setNombre("Ventilador Peabody");
        producto.setDescripcion("Ventilador de Pie Peabody PE-VP2061");
        producto.setMarca("PEABODY");
        producto.setPrecio(46999.00F);

        listaProductos.put(producto.getIdProducto(), producto);

        producto = new Producto();
        producto.setIdProducto(54546);
        producto.setNombre("Plancha ATMA");
        producto.setDescripcion("Plancha a Vapor ATMA PAV2339PI");
        producto.setMarca("ATMA");
        producto.setPrecio(23999.00F);

        listaProductos.put(producto.getIdProducto(), producto);

        producto = new Producto();
        producto.setIdProducto(87807);
        producto.setNombre("Pava Philips");
        producto.setDescripcion("Pava Eléctrica Philips HD9368/00");
        producto.setMarca("PHILIPS");
        producto.setPrecio(35999.00F);

        listaProductos.put(producto.getIdProducto(), producto);

        producto = new Producto();
        producto.setIdProducto(90987);
        producto.setNombre("Licuadora Smartlife");
        producto.setDescripcion("Licuadora de Pie Smartlife SL-BL1008WPN");
        producto.setMarca("SMARTLIFE");
        producto.setPrecio(29399.00F);

        listaProductos.put(producto.getIdProducto(), producto);

        producto = new Producto();
        producto.setIdProducto(45451);
        producto.setNombre("Pileta Mor");
        producto.setDescripcion("Pileta de Lona Mor 1000 litros");
        producto.setMarca("MOR");
        producto.setPrecio(30399.00F);

        listaProductos.put(producto.getIdProducto(), producto);

        model.addAttribute("listaClientes", listaClientes);
        model.addAttribute("listaProductos", listaProductos);
        return "index";
    }
}
