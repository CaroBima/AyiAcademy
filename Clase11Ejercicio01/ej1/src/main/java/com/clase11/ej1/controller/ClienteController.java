package com.clase11.ej1.controller;

import com.clase11.ej1.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class ClienteController {

    @GetMapping(value = "/cliente-html", produces = MediaType.TEXT_HTML_VALUE)
    public String getClientesHtml(){
        StringBuilder sb = new StringBuilder();
        Cliente cliente = new Cliente(1, "Pedro", "Picapiedras");

        sb.append("<html><head><title>Clientes</title></head>");
        sb.append("<body><h1>Clientes</h1>");
        sb.append("<p>Id: ").append(cliente.getNroCliente()).append("</p>");
        sb.append("<p>Nombre: ").append(cliente.getNombre()).append("</p>");
        sb.append("<p>Apellido: ").append(cliente.getApellido()).append("</p>");
        sb.append("</body></html>");

        return sb.toString();

    }

}
