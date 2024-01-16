package com.clase06.Ejercicio02.controller;

import com.clase06.Ejercicio02.model.Cliente;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ClienteController {
    HashMap<String, Cliente> Cliente = new HashMap<>();

}
